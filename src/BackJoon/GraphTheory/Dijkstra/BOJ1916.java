package BackJoon.GraphTheory.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//최소비용 구하기
public class BOJ1916 {

    static int N;
    static int M;

    static List<Node>[] lists;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        lists = new ArrayList[N + 1];

        for (int i = 1; i < N + 1; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int destination = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            lists[start].add(new Node(destination, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int destination = Integer.parseInt(st.nextToken());

        long result = Dijkstra(start, destination);

        System.out.println(result);
    }

    private static long Dijkstra(int start, int destination) {
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> (int) (n1.total - n2.total));
        boolean visit[] = new boolean[N + 1];
        visit[start] = true;
        long result = 0;

        for (int i = 0; i < lists[start].size(); i++) {
            Node node = lists[start].get(i);
            node.total = node.cost;
            pq.add(node);
        }

        while (!pq.isEmpty()) {

            Node cur = pq.poll();

            if (visit[cur.destination]) {
                continue;
            }

            visit[cur.destination] = true;

            if (cur.destination == destination) {
                result = cur.total;
                break;
            }

            for (int i = 0; i < lists[cur.destination].size(); i++) {
                Node next = lists[cur.destination].get(i);

                if (visit[next.destination])
                    continue;

                next.total += cur.total + next.cost;
                pq.add(next);
            }

        }

        return result;
    }

    static class Node {

        int destination;
        int cost;

        long total;

        public Node(int destination, int cost) {
            this.destination = destination;
            this.cost = cost;
        }

    }

}
