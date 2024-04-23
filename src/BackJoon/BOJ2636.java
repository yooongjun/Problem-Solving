package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2636 {

    static int map[][];
    static int X, Y;
    static int cnt = 0;
    static int mx[] = {0, -1, 0, 1};
    static int my[] = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s[] = bufferedReader.readLine().split(" ");
        X = Integer.parseInt(s[0]);
        Y = Integer.parseInt(s[1]);

        map = new int[X][Y];

        for (int i = 0; i < X; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            for (int j = 0; j < Y; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                if (map[i][j] == 1) {
                    cnt++;
                }
            }
        }

        int time = 0;
        int result = 0;

        while (cnt > 0) {
            result = meltCheese();
            time++;
        }

        System.out.println(time + "\n" + result);
    }

    static int meltCheese() {
        Queue<Air> queue = new LinkedList<>();
        boolean visit[][] = new boolean[X][Y];
        int melt = 0;
        queue.add(new Air(0, 0));
        visit[0][0] = true;

        while (!queue.isEmpty()) {
            Air air = queue.poll();

            for (int i = 0; i < 4; i++) {
                int xx = air.x + mx[i];
                int yy = air.y + my[i];

                if (xx >= 0 && xx < X && yy >= 0 && yy < Y && !visit[xx][yy]) {
                    visit[xx][yy] = true;
                    if (map[xx][yy] == 1) {
                        map[xx][yy] = 0;
                        cnt--;
                        melt++;
                    } else {
                        queue.add(new Air(xx, yy));
                    }
                }
            }
        }

        return melt;
    }

    static class Air{
        int x, y;

        public Air(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


}
