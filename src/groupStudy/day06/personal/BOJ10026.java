package groupStudy.day06.personal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 적록색약
 */
public class BOJ10026 {

    static int map[][];
    static int mx[] = {0, -1, 0, 1};
    static int my[] = {-1, 0, 1, 0};
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bufferedReader.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String s = bufferedReader.readLine();

            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        // 정상 시야 확인
        Queue<Info> queue = new LinkedList<>();
        boolean visit[][] = new boolean[N][N];
        int result1 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if(visit[i][j]) continue;

                queue.add(new Info(i, j));
                result1++;

                while (!queue.isEmpty()) {
                    Info cur = queue.poll();

                    for (int k = 0; k < 4; k++) {
                        int xx = cur.x + mx[k];
                        int yy = cur.y + my[k];

                        if(xx < 0 || xx >= N || yy < 0 || yy >= N || visit[xx][yy] || map[cur.x][cur.y] != map[xx][yy] ) continue;

                        visit[xx][yy] = true;
                        queue.add(new Info(xx, yy));
                    }
                }

            }
        }

        // 적록색약
        queue = new LinkedList<>();
        visit = new boolean[N][N];
        int result2 = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if(visit[i][j]) continue;

                queue.add(new Info(i, j));
                result2++;

                while (!queue.isEmpty()) {
                    Info cur = queue.poll();

                    for (int k = 0; k < 4; k++) {
                        int xx = cur.x + mx[k];
                        int yy = cur.y + my[k];

                        if(xx < 0 || xx >= N || yy < 0 || yy >= N || visit[xx][yy]) continue;

                        if (map[cur.x][cur.y] == 'G' && map[xx][yy] == 'B') continue;

                        if(map[cur.x][cur.y] == 'R' && map[xx][yy] == 'B') continue;

                        if(map[cur.x][cur.y] == 'B' && map[xx][yy] != 'B') continue;

                        visit[xx][yy] = true;
                        queue.add(new Info(xx, yy));
                    }
                }

            }
        }

        System.out.println(result1 + " " + result2);
    }

    private static class Info{
        int x, y;

        public Info(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


}
