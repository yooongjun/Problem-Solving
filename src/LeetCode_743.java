import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// Network Delay Time
public class LeetCode_743 {

    List<Edge> adjacentNodes[];
    PriorityQueue<Edge> edges = new PriorityQueue<>((e1, e2) -> e1.weight - e2.weight);
    static final int INF =  100000000;
    int distance[];

    public int networkDelayTime(int[][] times, int n, int k) {
        adjacentNodes = new ArrayList[n + 1];
        distance = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            adjacentNodes[i] = new ArrayList<>();
            distance[i] = INF;
        }

        for (int i = 0; i < times.length; i++) {

            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];

            adjacentNodes[u].add(new Edge(u, v, w));
        }

        dijkstra(k);

        int result = 0;

        for (int i = 1; i <= n; i++) {
            if (distance[i] == INF) {
                result = -1;
                break;
            }
            distance[i] = Integer.max(distance[i], result);
        }

        return  result;
    }

    void dijkstra(int start) {

        distance[start] = 0;
        for (Edge next : adjacentNodes[start]) {
            edges.add(new Edge(next.source, next.target, distance[next.source] + next.weight));
            distance[next.source] = distance[start] + next.weight;
        }

        while (!edges.isEmpty()) {
            Edge edge = edges.poll();
            System.out.printf("edge.. s: %d, d: %d, w: %d\n", edge.source, edge.target, edge.weight);

            for (Edge next : adjacentNodes[edge.source]) {
                if (distance[next.source] > distance[edge.source] + edge.weight) {
                    distance[next.source] = distance[edge.source] + edge.weight;
                    edges.add(new Edge(next.source, next.target, distance[next.source] + next.weight));
                }
            }
        }

    }


    class Edge{

        int source;
        int target;
        int weight;

        public Edge(int source, int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

}
