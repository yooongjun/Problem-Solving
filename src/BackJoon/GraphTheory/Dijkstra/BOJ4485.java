package BackJoon.GraphTheory.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 녹색 옷 입은 애가 젤다지?
public class BOJ4485 {

    static int mx[] = {0, -1, 0, 1};
    static int my[] = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i=1; ; i++) {

            int N = Integer.parseInt(br.readLine());

            if (N == 0)
                break;

            int map[][] = new int[N][N];

            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    map[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            int result = Dijkstra(map);
            System.out.println("Problem "+ i+": "+ result);
        }

    }

    private static int Dijkstra(int[][] map) {

        boolean[][] visit = new boolean[map.length][map.length];
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.acost - n2.acost);

        int result = 0;

        pq.add(new Node(0, 0, map[0][0]));

        while (!pq.isEmpty()){
            Node cur = pq.poll();

            if(visit[cur.x][cur.y])
                continue;

            if(cur.x == map.length-1 && cur.y == map.length-1){
                result = cur.acost;
                break;
            }

            visit[cur.x][cur.y] = true;

            for (int i = 0; i < 4; i++) {
                int xx = cur.x + mx[i];
                int yy = cur.y + my[i];

                if (xx >= 0 && xx < map.length && yy >= 0 && yy < map.length && !visit[xx][yy]) {
                    pq.add(new Node(xx, yy, cur.acost + map[xx][yy]));
                }
            }
        }

        return result;
    }

    static class Node{

        int x;
        int y;

        // 누적 비용
        int acost;

        public Node(int x, int y, int acost) {
            this.x = x;
            this.y = y;
            this.acost = acost;
        }

    }


}
