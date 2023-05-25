package BackJoon.GraphTheory;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 쉬운 최단거리
 */
public class BOJ14940 {

    static int mx[] = {0, -1, 0, 1};
    static int my[] = {-1, 0, 1, 0};

    static int n, m;
    static int map[][];
    static int dist[][];

    static int INF = 500000;

    static void bfs(int start_x, int start_y) {
        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(start_x, start_y));

        while (!queue.isEmpty()) {

            Info cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int xx = cur.x + mx[i];
                int yy = cur.y + my[i];

                if (xx >= 0 && xx < n && yy >= 0 && yy < m && map[xx][yy] == 1) {

                    if ( dist[xx][yy] > ( dist[cur.x][cur.y] + 1 ) ) {
                        dist[xx][yy] = dist[cur.x][cur.y] + 1;
                        queue.add(new Info(xx, yy));
                    }
                }
            }
        }


    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");

        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        map = new int[n][m];
        dist = new int[n][m];

        int start_x = 0, start_y = 0;

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");

            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                dist[i][j] = INF;

                if (map[i][j] == 2) {
                    start_x = i;
                    start_y = j;
                    dist[i][j] = 0;
                } else if (map[i][j] == 0) {
                    dist[i][j] = 0;
                }
            }
        }

        bfs(start_x, start_y);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m - 1; j++) {

                if (dist[i][j] == INF) {
                    bw.write("-1" + " ");
                    continue;
                }
                bw.write(dist[i][j] + " ");
            }

            bw.write( (dist[i][m - 1] == INF) ? "-1" : String.valueOf(dist[i][m - 1]) );
            bw.write("\n");
        }

        bw.flush();
    }

    static class Info{
        int x, y;
        public Info(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
