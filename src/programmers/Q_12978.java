package programmers;
import java.util.*;

public class Q_12978 {


        List<Edge> adjacentList[];
        int distance[];
        int INF = 500001;

        public int solution(int N, int[][] road, int K) {
            int answer = 0;

            adjacentList = new ArrayList[N + 1];
            distance = new int[N + 1];

            for(int i = 1; i <= N; i++){
                adjacentList[i] = new ArrayList<>();
                distance[i] = INF;
            }

            for(int i = 0; i < road.length; i++){

                int a = road[i][0];
                int b = road[i][1];
                int c = road[i][2];

                adjacentList[a].add(new Edge(b, c));
                adjacentList[b].add(new Edge(a, c));
            }

            answer = dijkstra(K);
            return answer;
        }

        int dijkstra(int limit){
            PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> e2.weight - e1.weight );
            int count = 0;

            distance[1] = 0;
            pq.add(new Edge(1, 0));

            while(!pq.isEmpty()){
                Edge cur = pq.poll();

                for(Edge edge : adjacentList[cur.dest]){

                    if(distance[edge.dest] > edge.weight + distance[cur.dest])
                    {
                        distance[edge.dest] = edge.weight + distance[cur.dest];
                        pq.add(new Edge(edge.dest, edge.weight + distance[cur.dest]));
                    }
                }
            }


            for(int i = 1; i < distance.length; i++){
                if(distance[i] <= limit){
                    count++;
                }
            }

            return count;
        }



        class Edge{

            int dest;
            int weight;

            public Edge(int dest, int weight){
                this.dest = dest;
                this.weight = weight;
            }

        }

    }
