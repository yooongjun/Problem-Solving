package SDS.day08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class BOJ3176 {

    static int parent[][] = new int[18][100001];
    static int n;
    static List<Info> map[] = new ArrayList[100001];

    static int minResult;
    static int maxResult;

    // 길이 저장하는 배열
    static int min[][] = new int[18][100001];
    static int max[][] = new int[18][100001];

    // dfs
    static boolean visit[] = new boolean[100001];
    static int depth[] = new int[100001];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        for(int i = 1; i <= 100000; i++)
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

        // 미리 배열 초기화
        for(int i = 0; i < 18; i++)
        {
            for(int j = 1; j < 100001; j++) {
                min[i][j] = 100001;
            }

        }


        // 1번 도시를 root 로 가정
        dfs(1, 0);
        // sparse table 생성
        makeSparse();

        int k = Integer.parseInt(br.readLine());
        for(int i = 1; i <= k ; i++)
        {
            int lca, diff_d, diff_e, minValue, maxValue;
            String s[] = br.readLine().split(" ");
            int d, e;
            d = Integer.parseInt(s[0]);
            e = Integer.parseInt(s[1]);

            lca = LCA(d,e);

            diff_d = depth[d] - depth[lca] - 1;
            diff_e = depth[e] - depth[lca] - 1;

            if(diff_d < 0)
            {
                minValue = min[diff_e][e];
                maxValue = max[diff_e][e];
            }
            else if(diff_e < 0)
            {
                minValue = min[diff_d][d];
                maxValue = max[diff_d][d];
            }
            else {
                minValue = Math.min( min[diff_d][d],  min[diff_e][e] );
                maxValue = Math.max( max[diff_d][d], max[diff_e][e] );
            }

            bw.append(minValue + " "  + maxValue + "\n");
        }

        bw.flush();
    }


    static void makeSparse(){
        for(int i = 1; i < 18; i++) {
            for(int j = 1; j < 100001; j++) {
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

        if(depthParam == n -1)
            return;

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

        if(depth[a] != depth[b])
        {
            if(depth[a] < depth[b]) {
                return LCA(b,a);
            }

            // 높이를 같게 만들기 위해 a를 옮김
            int diff = depth[a] - depth[b];
            for(int i = 0; diff > 0; i++) {

                if( (diff & 1) == 1) {
                    a = parent[i][a];
                }
                diff >>= 1;
            }

        }

        // 높이가 같은 경우
        if(a == b) return a;

        for(int i = 17; i >= 0; i--)
        {

            // 부모가 달라지는 시점 == LCA의 바로 아래 노드
            if(parent[i][a] != parent[i][b]) {
                a = parent[i][a];
                b = parent[i][b];
            }

        }

        // lca  == parent[0][a];

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
