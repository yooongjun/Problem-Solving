package BackJoon.GraphTheory.Dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// 거의 최단 경로

/**
 * 최단 경로의 간선을 저장하여 목적지부터 시작점으로 되돌아가며 간선에 표시해주고, 두번째 다익스트라에서 조건문을 통해 해당 간선들은 고려하지 않음.
 */
public class BOJ5719 {

    static int n,m,start,destination;

    // 인접 리스트
    static List<Info> map[];

    // 각 노드 사이의 거리
    static int distance[];

    // 최단 경로를 저장할 배열: 내 바로 전 노드를 저장
    static List<Integer> shortestPath[];

    // 최단 경로 판별용
    static boolean[][] isShortestPath;

    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            String s[] = br.readLine().split(" ");
            n = Integer.parseInt(s[0]);
            m = Integer.parseInt(s[1]);

            // 종료 조건
            if( ( n == 0 ) && ( m == 0 )) break;

            map = new ArrayList[n];
            isShortestPath = new boolean[n][n];
            shortestPath = new ArrayList[n];

            for(int i = 0; i < n; i++) map[i] = new ArrayList<>();

            s = br.readLine().split(" ");
            start = Integer.parseInt(s[0]);
            destination = Integer.parseInt(s[1]);

            for(int i = 0;  i < m; i++) {
                s = br.readLine().split(" ");
                int u, v, p;
                u = Integer.parseInt(s[0]);
                v = Integer.parseInt(s[1]);
                p = Integer.parseInt(s[2]);

                map[u].add(new Info(v,p));
            }

            // 다익스트라로 최단 경로 구하기
            dijkstra(start, destination);
            DFS(destination);
            int result = dijkstra(start, destination);

            if(result == INF)
                bw.append("-1\n");
            else
                bw.append(result + "\n");

        }
        bw.flush();

    }


    public static void DFS(int x) {
        if( x == start ) return;

        for(int i : shortestPath[x]) {
            if(!isShortestPath[i][x])
            {
                isShortestPath[i][x] = true;
                DFS(i);
            }
        }


    }

    public static int dijkstra(int start, int destination) {

        // 누적 가격 오름차순으로 우선순위 큐 생성
        PriorityQueue<Info> pq = new PriorityQueue<>((i1, i2) -> i1.cost - i2.cost );

        distance = new int[n];

        for(int i = 0; i < n; i++)
        {
            distance[i] = INF;
            shortestPath[i] = new ArrayList<>();
        }


        distance[start] = 0;
        pq.add(new Info(start, 0));

        while(!pq.isEmpty()) {

            Info now = pq.poll();

            for(Info next : map[now.x]) {

                if(isShortestPath[now.x][next.x])
                    continue;

                if(distance[next.x]== distance[now.x]+ next.cost  )
                    shortestPath[next.x].add(now.x);

                if(distance[next.x] > distance[now.x] + next.cost) {
                    shortestPath[next.x].clear();
                    shortestPath[next.x].add(now.x);
                    distance[next.x] =  distance[now.x] + next.cost;
                    pq.add(new Info(next.x, distance[now.x]+ next.cost ));
                    ;				}



            }

        }

        return distance[destination];
    }









    static class Info{

        int x;
        int cost;

        Info(int x, int cost){
            this.x = x;
            this.cost = cost;
        }



    }

}
