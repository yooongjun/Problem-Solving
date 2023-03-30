package BackJoon.GraphTheory.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 도로 포장
 */
public class BOJ1162 {

    static int n, m, k;
    static List<Info> map[];

    static long INF = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        k = Integer.parseInt(input[2]);

        map = new ArrayList[n+1];

        for (int i = 1; i <= n; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int from, to , cost;
            String[] s = br.readLine().split(" ");

            from = Integer.parseInt(s[0]);
            to = Integer.parseInt(s[1]);
            cost = Integer.parseInt(s[2]);

            // 양방향 그래프 입력
            map[from].add(new Info(to, cost,0));
            map[to].add(new Info(from, cost, 0));
        }

        long result = dijkstra(1, n);

        System.out.println(result);
    }

    static long dijkstra(int start, int destination){

        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingLong(i -> i.cost));

        // dist[i][j] i번째 도시를 방문 , 포장한 도로의 수 j
        long dist[][] = new long[n+1][k+1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
        }

        dist[start][0] = 0;
        pq.add(new Info(start, 0, 0));


        while (!pq.isEmpty()) {
            Info now = pq.poll();

            if (dist[now.node][now.cnt] < now.cost) {
                continue;
            }

            for (Info next : map[now.node]) {

                // 포장 안 하는 경우 cnt 값을 그대로 유지하며 값이 더 작은 경우에만 노드를 탐색
                if (dist[next.node][now.cnt] > (now.cost + next.cost) ) {

                    dist[next.node][now.cnt] = next.cost + now.cost;
                    pq.add(new Info(next.node, now.cost + next.cost, now.cnt));

                }

                // 도로 포장을 하는 경우
                if ( (now.cnt < k) && (now.cost < dist[next.node][now.cnt + 1]) ) {

                    dist[next.node][now.cnt + 1] = now.cost;
                    pq.add(new Info(next.node, now.cost, now.cnt+1));

                    }
                }
            }

        long result = INF;

        for (Long v : dist[n]) {

            result  =Math.min(v, result);
        }

        return result;
        }


    static class Info{

        int node;
        long cost;
        int cnt;

        public Info(int node, long cost, int cnt) {
            this.node = node;
            this.cost = cost;
            this.cnt = cnt;
        }
    }
}
