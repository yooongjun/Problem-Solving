package BackJoon.GraphTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 미로탐색
public class BOJ2178 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int mx[] = {-1, 0, 1, 0};
        int my[] = {0, 1, 0, -1};

        boolean[][] map = new boolean[N + 1][M + 1];
        boolean[][] checked = new boolean[N + 1][M + 1];



        for (int i = 1; i < N + 1; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j+1] = input.charAt(j) == '1' ? true : false;
            }
        }




        // 로직 실행
        node start = new node(1, 1, 1);
        Queue<node> queue = new LinkedList<>();
        int result = 0;

        queue.add(start);

        while (!queue.isEmpty()) {

            node cur = queue.poll();
            checked[cur.x][cur.y] = true;

            if (cur.x == N && cur.y == M) {
                result = cur.cnt;
                break;
            }

            for (int i = 0; i < 4; i++)
            {
                int xx = cur.x + mx[i];
                int yy = cur.y + my[i];

                if (0 < xx && xx < N + 1 && 0 < yy && yy < M + 1 && map[xx][yy] && !checked[xx][yy])
                {
                    queue.add(new node(xx, yy, cur.cnt + 1));
                    checked[xx][yy] = true;
                }
            }

        }

        System.out.println(result);
    }

    static class node {

        int x;
        int y;
        int cnt;

        public node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }


}
