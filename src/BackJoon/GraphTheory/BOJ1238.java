package BackJoon.GraphTheory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 파티
public class BOJ1238 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        List<Edge>[] town = new ArrayList[N + 1];

        for (int i = 1; i < N + 1; i++) {
            town[i] = new ArrayList<>();
        }

        // 간선 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            town[Integer.parseInt(st.nextToken())].add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int maxTime = 0;
        // x에서 각 마을까지의 시간
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] temp = new boolean[N + 1];
        int [] timeFromX = new int[N+1];

        temp[X] = true;

        for (int i = 0; i < town[X].size(); i++) {
            town[X].get(i).distance = town[X].get(i).t;
            pq.add(town[X].get(i));
        }

        while (!pq.isEmpty()) {
            Edge poll = pq.poll();

            if (temp[poll.node])
                continue;

            temp[poll.node] = true;
            timeFromX[poll.node] = poll.distance;

             for (int i = 0; i < town[poll.node].size(); i++) {
                Edge edge = town[poll.node].get(i);

                edge.distance = 0;

                if (temp[edge.node]) {
                    continue;
                }

                edge.distance = poll.distance + edge.t;
                pq.add(edge);
            }
        }

        // 각 노드에서 X 마을까지의 시간 구하기
        for (int i = 1; i < N + 1; i++) {

            if (i == X)
                continue;

            boolean visited[] = new boolean[N + 1];
            PriorityQueue<Edge> queue = new PriorityQueue<>();
            visited[i] = true;

            // 시작 노드를 큐에 추가함
            for (int j = 0; j < town[i].size(); j++) {
                Edge edge = town[i].get(j);
                edge.distance = edge.t;
                queue.add(edge);
            }

            while (!queue.isEmpty()) {
                Edge cur = queue.poll();

                if (visited[cur.node])
                        continue;
                visited[cur.node] = true;

                if (cur.node == X) {
                    maxTime = Math.max(timeFromX[i] + cur.distance, maxTime);
                    break;
                }

                for (int j = 0; j < town[cur.node].size(); j++) {
                    Edge edge = town[cur.node].get(j);

                    edge.distance = 0;

                    if (visited[edge.node])
                        continue;

                    edge.distance = cur.distance + edge.t;
                    pq.add(edge);
                }
            }
        }


        System.out.println(maxTime);
    }


    static class Edge implements Comparable<Edge>{

        int node;

        int t;
        
        // 누적 시간
        int distance= 0;

        public Edge(int node, int t){
            this.node = node;
            this.t = t;
        }

        @Override
        public int compareTo(Edge o) {
            return this.distance - o.distance;
        }
    }





}
