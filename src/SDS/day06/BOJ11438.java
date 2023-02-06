package SDS.day06;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// LCA2
public class BOJ11438 {

    static int n, m;
    // sparse 배열
    static int[][] parent = new int[18][100001];
    // 깊이 저장하는 배열
    static int[] depth = new int[100001];

    static boolean[] visit = new boolean[100001];

    // 인접 리스트
    static ArrayList<Integer>[] adj = new ArrayList[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for(int i = 1; i < n + 1; i ++){
            adj[i] = new ArrayList<>();
        }

        for(int i =1; i < n; i++){
            int a, b;
            String s[] = br.readLine().split(" ");
            a = Integer.parseInt(s[0]);
            b = Integer.parseInt(s[1]);

            // 인접 리스트 생성
            adj[a].add(b);
            adj[b].add(a);
        }

        // spanning tree 생성 - DFS
        visit[1] = true;
        dfs(0, 1);

        // sparse array 초기화
        for (int i = 1; i <= 17; i++) {
            for(int j = 1; j < 100001; j++){
                parent[i][j] = parent[i - 1][parent[i - 1][j]];
            }
        }

        // 정점 쌍 입력
        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            String s[] = br.readLine().split(" ");
            int a, b;
            a = Integer.parseInt(s[0]);
            b = Integer.parseInt(s[1]);

            System.out.println(LCA(a, b));
        }




    }

    static int LCA(int a, int b){

        // 높이가 다른 경우 조정 a의 높이가 더 크다고 가정
        if(depth[a] != depth[b]){
            if(depth[a] < depth[b])
                return LCA(b, a);

            int diff = depth[a] - depth[b];

            // 높이 맞추기
            for (int i = 0; diff > 0; i++) {

                if ((diff & 1) == 1) {
                    a = parent[i][a];
                }

                diff /= 2;
            }
        }

        if(a == b) return a;
        
        // 높이가 같은 경우
        for (int i = 17; i >= 0; i--) {
            if (parent[i][a] != parent[i][b]) {
                a = parent[i][a];
                b = parent[i][b];
            }
        }

        return parent[0][a];
    }

    static void dfs(int k, int x){

        visit[x] = true;
        depth[x] = k;

        for (Integer i: adj[x]) {

            if(visit[i])
                continue;
            parent[0][i] = x;
            dfs(k + 1, i);
        }
    }



}
