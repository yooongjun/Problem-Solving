package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ18126 {

    // 너구리 구구
    static int N;
    static List<Node> adj[];
    static long result = -1;
    static long[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bufferedReader.readLine());
        adj = new ArrayList[N + 1];
        dist = new long[N + 1];

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
            dist[i] = -1;
        }

        for (int i = 1; i < N; i++) {
            String[] s = bufferedReader.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int c = Integer.parseInt(s[2]);

            adj[a].add(new Node(b, c));
            adj[b].add(new Node(a, c));
        }

        dist[1] = 0;
        dfs(1,0);

        for (int i = 1; i <= N; i++) {
            result = Math.max(result, dist[i]);
        }

        System.out.println(result);
    }

    static void dfs(int num, long cost) {

        for (Node next : adj[num]) {
            if (dist[next.n] == -1) {
                dist[next.n] = cost + next.cost;
                dfs(next.n, cost + next.cost);
            }
        }
    }

    static class Node{
        int n;
        long cost;

        public Node(int n, long cost) {
            this.n = n;
            this.cost = cost;
        }
    }
}
