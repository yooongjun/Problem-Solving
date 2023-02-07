package SDS.day07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 최단 경로 알고리즘 중 다익스트라를 사용
 * 1 -> all
 * all -> 1
 * 특정 점 (1) --> 1
 * 가중치가 양수라면 다익스트라
 * 가중치가 음수가 나올 수 있으면 벨만포드 사용하기
 *
 */
public class BOJ1753 {

    static int v, e;
    static List<Edge> adj[];
    static PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> e1.acost - e2.acost);
    static int start;
    static int visit[];
    static final int INF = 210000;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        v = Integer.parseInt(s[0]);
        e = Integer.parseInt(s[1]);
        start = Integer.parseInt(br.readLine());

        visit = new int[v+1];
        adj = new ArrayList[v+1];

        // visit, adj 초기화
        for(int i =1; i <= v; i++) {
            adj[i] = new ArrayList<>();
            visit[i] = INF;
        }

        visit[start] = 0;

        for(int i = 0; i < e; i++) {
            s = br.readLine().split(" ");
            int u,v, w;
            u = Integer.parseInt(s[0]);
            v = Integer.parseInt(s[1]);
            w = Integer.parseInt(s[2]);

            // 인접 리스트 입력
            adj[u].add(new Edge(v, w));
        }


        // 최단 경로 찾기
        dijkstra();

        for(int i = 1; i<= v; i++){
            System.out.println( (visit[i]!=INF) ? visit[i] : "INF" );
        }

    }

    static void dijkstra() {

        // 시작 노드의 값 넣음

        for(Edge e: adj[start])
        {
            e.acost = e.cost;
            pq.add(e);
        }

        while(!pq.isEmpty()) {
            Edge cur = pq.poll();

            if(visit[cur.v] != INF )
                continue;

            visit[cur.v] = cur.acost;

            for(Edge e : adj[cur.v]) {

                // 아직 최단거리 확정 전이면
                if(visit[e.v] == INF) {

                    // 비용을 누적해서 PQ에 다시 넣는다.
                    e.acost = e.cost + cur.acost;
                    pq.add(e);
                }
            }
        }

    }



    static class Edge{

        int v;
        int cost;
        int acost;

        Edge(int v, int cost){
            this.v = v;
            this.cost = cost;
        }
    }

}
