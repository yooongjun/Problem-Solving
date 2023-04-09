package BackJoon.LCA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 정점들의 거리
 * 트리에서 두 정점의 거리는 각 정점과 두 정점의 LCA와의 거리를 더하는 방식으로 구할 수 있음.
 * 거리 정보를 저장하는 희소 행렬을 사용하엿음
 */
public class BOJ1761 {

    static int n;
    static int tmp = 1;

    // 결과
    static long result;

    // 각 노드의 깊이 저장
    static int depth[] = new int[100001];

    // 희소 행렬 생성
    static int parent[][];
    static long distance[][];

    // 인접 리스트
    static List<Info> map[];


    static int LCA(int a, int b) {

        result = 0;

        if(depth[a] != depth[b]) {
            if(depth[a] < depth[b]) {
                return LCA(b,a);
            }

            int diff = depth[a] - depth[b];

            for(int i = 0; diff > 0; i++) {

                if ( (diff & 1) == 1) {
                    result += distance[i][a];
                    a = parent[i][a];
                }
                diff >>= 1;
            }
        }

        if( a == b) {
            return a;
        }


        for(int i = tmp; i >= 0; i --) {

            if(parent[i][a] != parent[i][b]) {

                result = result + distance[i][a] + distance[i][b];

                a = parent[i][a];
                b = parent[i][b];
            }
        }

        result += distance[0][a] + distance[0][b];

        return parent[0][a];
    }

    static void makeSparse() {

        for(int  i = 1 ; i <= 15; i++) {
            for(int j = 1; j < 40001; j++) {
                parent[i][j] = parent[i-1][parent[i-1][j]];
                distance[i][j] = distance[i-1][j] + distance[i-1][parent[i-1][j]];
            }
        }
    }




    static void BFS() {
        boolean visit[] = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        visit[1] = true;
        depth[1] = 0;

        while(!queue.isEmpty()) {
            int now = queue.poll();

            for(Info next: map[now]) {
                if(!visit[next.node]) {
                    depth[next.node] = depth[now] + 1;
                    visit[next.node] = true;
                    parent[0][next.node] = now;
                    distance[0][next.node] = next.cost;
                    queue.add(next.node);
                }
            }
        }



    }


    public static void main(String[] args) throws IOException
    {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        map = new ArrayList[n+1];
        for(int i =0; i <= n ; i ++) {
            map[i] = new ArrayList<>();
        }


        int t = 1;
        tmp = 0;
        while(t < 40000) {
            t *= 2;
            tmp ++;
        }

        parent = new int[tmp+1][100001];
        distance = new long[tmp+1][100001];

        for(int i = 1; i <= n-1; i++) {
            int a, b, c;
            String s[] = br.readLine().split(" ");
            a = Integer.parseInt(s[0]);
            b = Integer.parseInt(s[1]);
            c = Integer.parseInt(s[2]);

            map[a].add(new Info(b,c ));
            map[b].add(new Info(a,c));
        }

        // 희소 행렬
        BFS();
        makeSparse();

        int k = Integer.parseInt(br.readLine());
        for(int i = 0; i < k; i++) {
            int d, e;
            String s[] = br.readLine().split(" ");

            d = Integer.parseInt(s[0]);
            e = Integer.parseInt(s[1]);

            LCA(d,e);
            bw.append(result + " \n");
        }
        bw.flush();


    }

    static class Info{
        int node;
        int cost;

        Info(int node, int cost){
            this.node = node;
            this.cost = cost;
        }
    }


}
