package BackJoon.GraphTheory.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 특정한 최단 경로
 * 1 -> u -> v -> n
 * 1 -> v -> u -> n
 * 최단 거리 값 비교
 */
public class BOJ1504 {

    static int n, e, u, v;
    static List<Info>[] map;
    static int distance_x[];
    static int distance_u[];
    static int distance_v[];
    static final int INF  = 200000000;

    public static void dijkstra(int start, int destination, int[] distance) {

        Arrays.fill(distance, INF);

        PriorityQueue<Info> pq = new PriorityQueue<>((i1, i2) -> i1.cost - i2.cost);

        distance[start] = 0;
        pq.add(new Info(start, 0));

        while(!pq.isEmpty()) {

            Info now = pq.poll();

            for(Info next : map[now.node]) {

                if(distance[next.node] > now.cost + next.cost) {
                    distance[next.node] = now.cost + next.cost;
                    pq.add(new Info(next.node, now.cost + next.cost));
                }

            }

        }


    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        map = new ArrayList[n + 1];
        distance_x = new int[n+1];
        distance_u = new int[n+1];
        distance_v = new int[n+1];


        for(int i = 1; i <= n; i++)
            map[i] = new ArrayList<>();

        for(int i = 0; i < e; i++) {
            int a,b,c;
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            map[a].add(new Info(b,c));
            map[b].add(new Info(a,c));
        }

        st = new StringTokenizer(br.readLine());
        u = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        dijkstra(1,n, distance_x);
        dijkstra(u,n, distance_u);
        dijkstra(v,n, distance_v);

        int value1 = distance_x[u] + distance_u[v] + distance_v[n];
        int value2 = distance_x[v] + distance_v[u] + distance_u[n];

        int result = Math.min(value1 , value2);

        if(result >= INF)
            System.out.println(-1);
        else
            System.out.println(result);



    }

    static class Info{

        int node;
        int cost;

        Info(int node, int cost){
            this.node = node;
            this.cost = cost;
        }

    }
}
