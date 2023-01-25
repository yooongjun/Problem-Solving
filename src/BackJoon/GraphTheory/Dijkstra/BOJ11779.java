package BackJoon.GraphTheory.Dijkstra;
import java.util.*;
import java.io.*;


// 최소비용 구하기2
public class BOJ11779 {

    static int n;
    static int m;
    static ArrayList<Edge>[] graph;

    static final int INF = Integer.MAX_VALUE;
    static int minAcost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];

        for (int i = 1; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int destination = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[start].add(new Edge(destination, cost));
        }

        st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int destination = Integer.parseInt(st.nextToken());

        List<Integer> result = dijkstra(start, destination);

        // 결과 출력
        System.out.println(minAcost);
        System.out.println(result.size());
        for (int i = result.size() - 1; i >= 0; i--) {
            System.out.print(result.get(i) + " ");
        }
    }

    public static List<Integer> dijkstra(int start, int destination) {

        // 1번 행에 내 이전 노드 번호를 저장
        int visit[][] = new int[2][n + 1];
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Edge> queue = new PriorityQueue<>((e1, e2) -> e1.acost - e2.acost);

        for (int i = 0; i < n + 1; i++) {
            visit[0][i] = i != start ? INF : 0;
        }

        if (start == destination) {
            minAcost = 0;
            result.add(start);
            return result;
        }


        for (int i = 0; i < graph[start].size(); i++) {
            Edge cur = graph[start].get(i);
            cur.setAcost(cur.cost);
            cur.setPrev(start);
            queue.add(cur);
        }


        while(!queue.isEmpty()){
            Edge cur = queue.poll();

            if (visit[0][cur.node] != INF) {
                continue;
            }

            visit[0][cur.node] = cur.acost;
            visit[1][cur.node] = cur.prev;

            if (cur.node == destination) {
                break;
            }


            for (int i = 0; i < graph[cur.node].size(); i++) {
                Edge next = graph[cur.node].get(i);

                if(visit[0][next.node] == INF){
                    next.setPrev(cur.node);
                    next.setAcost(cur.acost + next.cost);
                    queue.add(next);
                }
            }
        }

        // 최단 경로를 반환함
        int tmp = destination;
        while (true) {
            result.add(tmp);
            if (tmp == start) {
                break;
            }

            tmp = visit[1][tmp];
        }
        minAcost = visit[0][destination];
        return result;
    }


    private static class Edge{

        int node;

        int cost;
        
        // 누적 비용
        int acost;
        
        // 이전 노드 번호
        int prev;

        Edge(int node, int cost){
            this.node = node;
            this.cost = cost;
        }

        void setAcost(int acost) {
            this.acost = acost;
        }

        void setPrev(int prev) {
            this.prev = prev;
        }

    }


}
