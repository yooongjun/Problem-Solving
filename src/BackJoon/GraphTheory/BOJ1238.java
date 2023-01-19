package BackJoon.GraphTheory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 파티
public class BOJ1238 {

    // X에서 다른 노드로의 최단 거리
    static int minDistanceX[];

    static int N;
    static int M;
    static int X;

    static List<Edge>[] town;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        minDistanceX = new int[N + 1];
        town = new ArrayList[N + 1];

        for (int i = 1; i < N + 1; i++) {
            town[i] = new ArrayList<>();
        }

        // 간선 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            town[Integer.parseInt(st.nextToken())].add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int result = 0;

        Dijkstra(X, 0);

        for (int i = 1; i < N + 1; i++) {
            if (i != X)
                result = Math.max(Dijkstra(i, X) + minDistanceX[i], result);
        }

        System.out.println(result);
    }

    public static int Dijkstra(int start, int destination) {
        int visited[] = new int[N + 1];
        PriorityQueue<Edge> queue = new PriorityQueue<>();

        // 시작 노드에 존재하는 Edge들을 queue에 넣음
        for (int i = 0; i < town[start].size(); i++) {
            Edge cur = town[start].get(i);
            cur.accumulateTime = cur.time;
            queue.add(cur);
        }

        while (!queue.isEmpty()) {
            Edge cur = queue.poll();

            if (visited[cur.node] != 0)
                continue;

            visited[cur.node] = cur.accumulateTime;

            if (cur.node == destination && start != X) {
                cur.accumulateTime = 0;
                break;
            }

            for (int i = 0; i < town[cur.node].size(); i++) {
                Edge next = town[cur.node].get(i);

                if (visited[next.node] == 0 && next.node != start) {
                    next.accumulateTime = next.time + cur.accumulateTime;
                    queue.add(next);
                }
            }

        }

        if (start == X) {
            minDistanceX = visited;
        }

        return visited[destination];
    }



    static class Edge implements Comparable<Edge>{

        int node;

        int time;

        int accumulateTime = 0;

        public Edge(int node, int time){
            this.node = node;
            this.time = time;
        }

        @Override
        public int compareTo(Edge o) {
            return this.accumulateTime - o.accumulateTime;
        }
    }

}
