package SDS.day08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * 도로 네트워크
 * N개의 도시 , N-1 개의 도로 , 모두 연결
 * --> 트리 자료구조임을 알 수 있다.
 * 한 노드에서 다른 노드로의 경로는 반드시 그 둘의 LCA를 거침.
 * 따라서 A ~ LCA(A,B) , B ~ LCA(A,B)사이에 존재하는 min, max 값을 찾는 방식
 */
public class BOJ3176 {

    static int parent[][];
    static int n;
    static List<Info> map[];

    static int minResult;
    static int maxResult;

    // 길이 저장하는 배열
    static int min[][];
    static int max[][];

    // dfs
    static boolean visit[];
    static int depth[];

    static int LogN = 0;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        int t = 1;
        while(t < n) {
            LogN ++;
            t  *= 2;
        }

        // 초기화
        parent = new int[LogN + 1][n+1];
        map = new ArrayList[n+1];
        min = new int[LogN+1][n+1];
        max = new int[LogN+1][n+1];
        visit = new boolean[n+1];
        depth = new int[n+1];

        for(int i = 1; i <= n; i++)
            map[i] = new ArrayList<>();

        for(int i = 1; i < n; i++) {
            String s[] = br.readLine().split(" ");
            int a, b, c;
            a = Integer.parseInt(s[0]);
            b = Integer.parseInt(s[1]);
            c = Integer.parseInt(s[2]);

            map[a].add(new Info(b, c));
            map[b].add(new Info(a,c));
        }

        // 1번 도시를 root 로 가정
        dfs(1, 0);

        // sparse table 생성
        makeSparse();

        int k = Integer.parseInt(br.readLine());
        for(int i = 1; i <= k ; i++)
        {
            String s[] = br.readLine().split(" ");
            int d, e;
            d = Integer.parseInt(s[0]);
            e = Integer.parseInt(s[1]);

            LCA(d,e);

            bw.append(minResult + " "  + maxResult + "\n");
        }

        bw.flush();
    }

    // 희소 행렬 생성
    static void makeSparse(){
        for(int i = 1; i < LogN + 1; i++) {
            for(int j = 1; j < n + 1; j++) {
                parent[i][j] = parent[i-1][parent[i-1][j]];
                min[i][j] = Math.min(min[i-1][j], min[i - 1][parent[i-1][j]]);
                max[i][j] = Math.max(max[i-1][j], max[i - 1][parent[i-1][j]]);
            }
        }
    }


    static void dfs(int now, int depthParam) {

        // 방문 순서 저장
        depth[now] = depthParam;
        visit[now] = true;

        for(Info i: map[now]) {

            if(visit[i.x] == false )
            {
                // 한 칸 위의 부모 저장
                parent[0][i.x] = now;

                // 한 칸 위로의 값 저장
                min[0][i.x]= i.cost;
                max[0][i.x]= i.cost;

                dfs(i.x, depthParam + 1 );
            }
        }
    }

    // a와 b의 LCA 구하기
    static int LCA(int a, int b)
    {

        minResult = Integer.MAX_VALUE;
        maxResult = 0;

        if(depth[a] != depth[b])
        {
            if(depth[a] < depth[b]) {
                return LCA(b,a);
            }

            // 높이를 같게 만들기 위해 a를 옮김
            int diff = depth[a] - depth[b];
            for(int i = 0; diff > 0; i++) {

                if( (diff & 1) == 1) {
                    minResult = Math.min( minResult, min[i][a]);
                    maxResult = Math.max( maxResult, max[i][a]);
                    a = parent[i][a];
                }
                diff >>= 1;
            }

        }

        // 높이가 같은 경우
        if(a == b) return a;

        for(int i = LogN; i >= 0; i--)
        {

            // 부모가 달라지는 시점으로 계속 이동하면 LCA의 바로 아래 노드로 이동
            if(parent[i][a] != parent[i][b]) {
                // min, max 업데이트
                minResult = Math.min( minResult, Math.min(min[i][a], min[i][b]));
                maxResult = Math.max( maxResult, Math.max(max[i][a], max[i][b]));
                a = parent[i][a];
                b = parent[i][b];
            }

        }

        // lca  == parent[0][a];

        minResult = Math.min( minResult, Math.min(min[0][a], min[0][b]));
        maxResult = Math.max( maxResult, Math.max(max[0][a], max[0][b]));

        return parent[0][a];
    }

    static class Info{

        int x;
        int cost;

        Info(int x, int cost)
        {
            this.x = x; this.cost = cost;
        }


    }

}
