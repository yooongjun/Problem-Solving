package BackJoon.GraphTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 탈출
public class BOJ3055 {

    static char map[][];
    static int mx[] = {0, -1, 0 ,1};
    static int my[] = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<NODE> water = new LinkedList<>();
        Queue<NODE> move = new LinkedList<>();

        map = new char[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())];

        for (int i = 0; i < map.length; i++) {
            String s = br.readLine();
            for (int j = 0; j < map[0].length; j++) {
                char c = s.charAt(j);
                map[i][j] = c;

                if (c == '*') {
                    water.add(new NODE(i, j));
                }

                if (c == 'S') {
                    move.add(new NODE(i, j));
                }

            }
        }

        int result = BFS(water, move);

        if (result != -1) {
            System.out.println(result);
            return;
        }

        System.out.println("KAKTUS");
    }

    private static int BFS(Queue<NODE> water, Queue<NODE> move) {
        int result = -1;

        while (true) {

            if (move.isEmpty()) {
                break;
            }

            int waterSize = water.size();
            int moveSize = move.size();

            // 이동

            for(int idx = 0; idx < moveSize; idx++) {

                NODE curMove = move.poll();

                if (map[curMove.x][curMove.y] == '*') {
                    continue;
                }

                for (int i = 0; i < 4; i++) {
                    int xx = curMove.x + mx[i];
                    int yy = curMove.y + my[i];
                    if (xx >= 0 && xx < map.length && yy >= 0 && yy < map[0].length) {
                        if (map[xx][yy] == '.') {
                            map[xx][yy] = 'S';
                            move.add(new NODE(xx, yy, curMove.cnt + 1));
                        } else if (map[xx][yy] == 'D') {
                            result = curMove.cnt + 1;
                            return result;
                        }
                    }
                }
            }

            for(int idx = 0; idx < waterSize; idx++) {
                NODE curWater = water.poll();

                for (int i = 0; i < 4; i++) {
                    int xx = curWater.x + mx[i];
                    int yy = curWater.y + my[i];
                    if (xx >= 0 && xx < map.length && yy >= 0 && yy < map[0].length && map[xx][yy] != '*' && map[xx][yy] != 'D' && map[xx][yy] != 'X') {
                        map[xx][yy] = '*';
                        water.add(new NODE(xx, yy));
                    }
                }
            }
        }
        return result;
    }


    private static class NODE{
        int x;
        int y;
        int cnt = 0;

        NODE(int x, int y) {
            this.x = x;
            this.y = y;
        }

        NODE(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

    }
}
