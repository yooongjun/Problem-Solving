package groupStudy.day07.group;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 세 번 이내에 사과를 먹자
 */
public class BOJ26169 {

    static int mx[] = {0, -1, 0, 1};
    static int my[] = {-1, 0, 1, 0};
    static int map[][] = new int[5][5];
    static int start_x, start_y;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            String s[] = bufferedReader.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        String[] split = bufferedReader.readLine().split(" ");
        start_x = Integer.parseInt(split[0]);
        start_y = Integer.parseInt(split[1]);

        findApple(start_x, start_y, 0, 0);

        System.out.println(result);
    }

    public static void findApple(int x, int y, int depth, int apple) {
        // 이동한 칸이 사과면 apple 값을 하나 더해줌
        if (map[x][y] == 1) {
            apple++;
        }

        // 세 번 이동하는 경우 탐색 종료
        if (depth == 3) {
            // 사과를 두개 이상 먹은 경우 결과를 1로 바꿔줌
            if (apple >= 2) {
                result = 1;
            }
            return;
        }

        // 좌, 상, 우, 하 방향으로 이동하면서 dfs 수행
        for (int i = 0; i < 4; i++) {
            int xx = x + mx[i];
            int yy = y + my[i];

            // 배열의 범위 밖으로 벗어나거나 벽인 경우 이동을 안 함
            if (xx < 0 || xx >= 5 || yy < 0 || yy >= 5 || map[xx][yy] == -1) {
                continue;
            }

            // 지금 이동한 칸으로 다시 돌아올 수 없으므로 임시로 벽을 세움
            map[x][y] = -1;
            findApple(xx, yy, depth + 1, apple);
            // 다음 번의 탐색에는 세운 벽을 다시 없앰
            map[x][y] = 0;
        }



    }



}
