package BackJoon.GraphTheory.Dijkstra;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * k번째 최단경로 찾기
 */
public class BOJ1854 {

    static int n,m,k;

    static final int INF = 150000;

    // 최단 경로 배열
    static int distance[];
    static int count[];

    static List<Info> map[];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s[] = br.readLine().split(" ");

        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        k = Integer.parseInt(s[2]);

        map = new ArrayList[n+1];

        for(int i = 1; i < n+1; i++) {
            map[i] = new ArrayList<>();
        }
        distance = new int[n+1];

        for(int i = 0; i < m; i++) {
            s = br.readLine().split(" ");
            int a, b, c;
            a = Integer.parseInt(s[0]);
            b = Integer.parseInt(s[1]);
            c = Integer.parseInt(s[2]);

            map[a].add(new Info(b,c));
        }


        dijkstra(1);

        for(int i = 1; i < n +1; i++) {
            if(count[i] < k) {
                bw.append(-1+"\n");
            }
            else
                bw.append(distance[i] + "\n");
        }


        bw.flush();
    }


    static void dijkstra(int start) {
        PriorityQueue<Info> pq = new PriorityQueue<>((i1, i2) -> i1.cost - i2.cost);
        Arrays.fill(distance, 0);
        count = new int[n+1];

        pq.add(new Info(start, 0));

        while(!pq.isEmpty()) {
            Info now = pq.poll();

            if(count[now.x] == k)
                continue;

            count[now.x]++;
            distance[now.x]= now.cost;

            // 다익스트라와 달리 모든 간선을 고려함
            for(Info next: map[now.x])
            {
                if(count[next.x]< k )
                    pq.add(new Info(next.x, next.cost + now.cost));
            }

        }
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
