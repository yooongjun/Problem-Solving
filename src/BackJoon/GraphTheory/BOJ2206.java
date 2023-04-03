package BackJoon.GraphTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2206 {

    static int n,m;
    static char map[][];

    static int mx[] = {0, -1, 0, 1};
    static int my[] = {-1, 0, 1, 0};

    static int BFS(){

        Queue<Info> queue = new LinkedList<>();
        boolean visit[][][] = new boolean[2][n+1][m+1];

        visit[0][1][1] = true;
        visit[1][1][1] = true;

        queue.add(new Info(1, 1, 1, 1));

        while (!queue.isEmpty()) {
            Info now = queue.poll();

            if (now.x == n && now.y == m) {
                return now.cost;
            }

            for (int i = 0; i < 4; i++) {
                int xx = now.x + mx[i];
                int yy = now.y + my[i];

                if (xx > 0 && xx <= n && yy > 0 && yy <= m) {

                    // 이미 방문한 경우
                    if(visit[now.cnt][xx][yy]) continue;

                    // 아직 방문하지 않았고 벽인 경우
                    if (map[xx][yy] == '1' && now.cnt == 1) {
                        visit[0][xx][yy] = true;
                        queue.add(new Info(xx, yy, 0, now.cost + 1));
                    }

                    if (map[xx][yy] == '0') {
                        visit[now.cnt][xx][yy] = true;
                        queue.add(new Info(xx, yy, now.cnt, now.cost + 1));
                    }

                }
            }
        }

        return -1;
    }




    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        map = new char[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {

            char[] input = br.readLine().toCharArray();

            for (int j = 1; j <= m; j++) {
                map[i][j] = input[j - 1];
            }

        }

        int result = BFS();

        System.out.println(result);
  }

    static class Info{

        int x, y, cost;

        // 벽 부순 횟수
        int cnt;

        public Info(int x, int y, int cnt, int cost) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.cost = cost;
        }
    }

}
