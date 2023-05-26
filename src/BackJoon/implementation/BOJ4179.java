package BackJoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 불!
 */
public class BOJ4179 {

    static int mx[] = {0, -1, 0, 1};
    static int my[] = {-1, 0, 1, 0};

    static int r, c;
    static char map[][];
    static int visit[][];
    static int INF = 150000;

    static List<Info> fire = new ArrayList<>(); // 불 시작지점
    static Info J; // 지훈 시작지점
    
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bufferedReader.readLine().split(" ");

        r = Integer.parseInt(s[0]);
        c = Integer.parseInt(s[1]);

        map = new char[r][c];
        visit = new int[r][c];

        for (int i = 0; i < r; i++) {
            Arrays.fill(visit[i], INF);
            String input = bufferedReader.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = input.charAt(j);

                if (map[i][j] == 'F') {
                    fire.add(new Info(i, j, true));
                }

                if (map[i][j] == 'J') {
                    J = new Info(i, j, false);
                    visit[i][j] = 0;
                }

            }
        }

        int result = escape();

        System.out.println((result==-1) ? "IMPOSSIBLE": result);
    }

    static int escape() {
        Queue<Info> queue = new LinkedList<>();

        queue.add(J);

        for (Info info : fire) {
            queue.add(info);
        }

        while (!queue.isEmpty()) {
            Info cur = queue.poll();

            // 지훈이
            if (!cur.isFire) {

                if(map[cur.x][cur.y] == 'F') continue;

                for (int i = 0; i < 4; i++) {
                    int xx = cur.x + mx[i];
                    int yy = cur.y + my[i];

                    // 탈출성공
                    if (xx < 0 || xx >= r || yy < 0 || yy >= c)
                    {
                        return visit[cur.x][cur.y] + 1;
                    }

                    // 이동 가능한 공간이면서 처음 가는 곳이면 다음 칸으로 이동
                    if (xx >= 0 && xx < r && yy >= 0 && yy < c && map[xx][yy] == '.' && visit[xx][yy] == INF)
                    {
                        visit[xx][yy] = visit[cur.x][cur.y] + 1;
                        map[xx][yy] = 'J';
                        queue.add(new Info(xx, yy, false));
                    }

                }
            }
            // 불
            else {
                for (int i = 0; i < 4; i++) {
                    int xx = cur.x + mx[i];
                    int yy = cur.y + my[i];

                    // 얘는 벽이나 불 아니면 한칸씩 번집니다.
                    if (xx >= 0 && xx < r && yy >= 0 && yy < c && map[xx][yy] != '#' && map[xx][yy] != 'F')
                    {
                        map[xx][yy] = 'F';
                        queue.add(new Info(xx, yy, true));
                    }
                }
            }
        }

        return -1;
    }


    static class Info {

        int x, y;
        boolean isFire;

        public Info(int x, int y, boolean isFire) {
            this.x = x;
            this.y = y;
            this.isFire = isFire;
        }
    }

}
