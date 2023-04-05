package BackJoon.GraphTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 알파벳
 */
public class BOJ1987 {

    static int result = 0;
    static char map[][];
    static int R, C;

    static int mx[] = {0, -1, 0, 1};
    static int my[] = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bufferedReader.readLine().split(" ");

        R = Integer.parseInt(s[0]);
        C = Integer.parseInt(s[1]);

        map = new char[R + 1][C + 1];

        for (int i = 1; i <= R; i++) {
            String input = bufferedReader.readLine();
            for (int j = 1; j <= C; j++) {
                map[i][j] = input.charAt(j - 1);
            }
        }

        DFS(1,1,1, 1 << (map[1][1] - 'A'));

        System.out.println(result);
    }


    static void DFS(int x, int y, int cnt,int visit){

        for (int i = 0; i < 4; i++) {

            int xx = x + mx[i];
            int yy = y + my[i];

            if (xx > 0 && xx <= R && yy > 0 && yy <= C) {

                int idx = map[xx][yy] - 'A';

                // 해당 알파벳을 이미 방문한경우 탐색 종료
                if (((visit >> idx) & 1) == 1) {
                    result = Math.max(cnt, result);
                    continue;
                }

                DFS(xx, yy, cnt + 1, visit | (1 << idx) );
            }
        }
    }


}

