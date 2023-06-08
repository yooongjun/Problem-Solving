package BackJoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ17144 {

    static int r, c, t;
    static int map[][];
    static Queue<dust> dustQueue = new LinkedList<>();
    static int[] mx = {0, -1, 0, 1};
    static int[] my = {-1, 0, 1, 0};
    static List<Info> airCleanerList = new ArrayList<>();

    static int start_x1, start_x2;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");

        r = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);
        t = Integer.parseInt(input[2]);

        map = new int[r + 1][c + 1];

        for (int i = 0; i < r; i++) {
            String[] s = bufferedReader.readLine().split(" ");
            for (int j = 0; j < c; j++) {
                map[i + 1][j + 1] = Integer.parseInt(s[j]);

                if (map[i + 1][j + 1] == -1) {
                    airCleanerList.add(new Info(i + 1, j + 1));
                }
//
//                else if (map[i + 1][j + 1] != 0) {
//                    dustQueue.add(new dust(i + 1, j + 1, map[i + 1][j + 1]));
//                }

            }
        }

        start_x1 = airCleanerList.get(0).x;
        start_x2 = airCleanerList.get(1).x;

        while (t-->0){
            spreadDust();
            doAirClean();
        }

        System.out.println(getTotalDust());
    }

    public static void printArr() {
        System.out.println("printArr");
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int getTotalDust() {
        int result = 0;
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if(map[i][j] != -1) result += map[i][j];
            }
        }
        return result;
    }


    private static void doAirClean() {

        int tmp = map[start_x1][2];
        map[start_x1][2] = 0;
        // 반시계
        // 서 -> 동
        for (int i = 3; i <= c; i++) {
            int t = map[start_x1][i];
            map[start_x1][i] = tmp;
            tmp = t;
        }


        // 남 -> 북
        for (int i = start_x1 -1 ; i > 0; i--) {
            int t = map[i][c];
            map[i][c] = tmp;
            tmp = t;
        }


        // 동 -> 서
        for (int i = c -1 ; i > 0; i--) {
            int t = map[1][i];
            map[1][i] = tmp;
            tmp = t;
        }

        // 북 -> 남
        for (int i = 2; i < start_x1; i++) {
            int t = map[i][1];
            map[i][1] = tmp;
            tmp = t;
        }

        // 시계
        // 서 -> 동
        tmp = map[start_x2][2];
        map[start_x2][2] = 0;

        for (int i = 3; i <= c; i++) {
            int t = map[start_x2][i];
            map[start_x2][i] = tmp;
            tmp = t;
        }
        // 북 -> 남
        for (int i = start_x2 + 1; i <= r; i++) {
            int t = map[i][c];
            map[i][c] = tmp;
            tmp = t;
        }
        // 동 -> 서
        for (int i = c - 1; i > 0; i--) {
            int t = map[r][i];
            map[r][i] = tmp;
            tmp = t;
        }

        // 남 -> 북
        for (int i = r -1 ; i > start_x2; i--) {
            int t = map[i][1];
            map[i][1] = tmp;
            tmp = t;
        }

    }

    private static void spreadDust() {
        int tmp[][] = new int[r + 1][c + 1];

        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {

                if(map[i][j] == 0 || map[i][j] == -1) continue;

                dust dust = new dust(i, j, map[i][j]);
                int spreadAmount = dust.spreadAmount();
                int cnt = 0;

                for (int k = 0; k < 4; k++) {
                    int xx = i + mx[k];
                    int yy = j + my[k];

                    if (xx > 0 && xx <= r && yy > 0 && yy <= c && map[xx][yy] != -1) {
                        tmp[xx][yy] += spreadAmount;
                        cnt++;
                    }
                }
                dust.setAmount(cnt, spreadAmount);
                dustQueue.add(dust);
            }
        }

        while (!dustQueue.isEmpty()) {

            dust cur = dustQueue.poll();

            tmp[cur.x][cur.y] += cur.amount;
        }

        tmp[start_x1][1] = -1;
        tmp[start_x2][1] = -1;
        map = tmp;
    }

    // 공기청정기
    static class Info{

        int x, y;

        public Info(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    // 미세먼지 클래스
    static class dust {
        int x, y, amount;

        public dust(int x, int y, int amount) {
            this.x = x;
            this.y = y;
            this.amount = amount;
        }

        public int spreadAmount() {
            return this.amount / 5;
        }

        public void setAmount(int n, int spread) {
            this.amount = this.amount - (spread) * n;
        }
    }

}
