package BackJoon.GraphTheory.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 택배 배송
 */
public class BOJ5972 {
    static int N, M;
    static int result = 0;
    static List<Info>[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        map = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) map[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            int a, b, c;
            String[] input = br.readLine().split(" ");

            a = Integer.parseInt(input[0]);
            b = Integer.parseInt(input[1]);
            c = Integer.parseInt(input[2]);

            map[a].add(new Info(b, c));
            map[b].add(new Info(a, c));
        }

        dijkstra();

        System.out.println(result);
    }

    static void dijkstra() {
        PriorityQueue<Info> pq = new PriorityQueue<>((i1, i2) -> i1.cost - i2.cost);
        int dist[] = new int[N + 1];
        Arrays.fill(dist, 100000000);
        dist[1] = 0;

        pq.add(new Info(1, 0));

        while (!pq.isEmpty()) {
            Info cur = pq.poll();

            for (Info next : map[cur.node]) {

                if (dist[next.node] > next.cost + cur.cost) {

                    dist[next.node] = next.cost + cur.cost;
                    pq.add(new Info(next.node, next.cost + cur.cost));
                }
            }
        }

        result = dist[N];
    }

    static class Info{

        int node;
        int cost;

        public Info(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

}
