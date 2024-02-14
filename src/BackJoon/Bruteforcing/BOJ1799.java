package BackJoon.Bruteforcing;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 비숍

public class BOJ1799 {

    static int n;
    static int map[][];
    static boolean visit[][];
    static int mx[] = {-1, -1, 1, 1};
    static int my[] = {-1, 1, 1, -1};
    static int max_W = 0, max_B = 0;

    static int count_W = 0, count_B = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());

        map = new int[n][n];
        visit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String[] s = bufferedReader.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(s[j]);
                if(map[i][j] == 1){
                    if ((i + j) % 2 == 0) {
                        count_B++;
                    } else {
                        count_W++;
                    }
                }
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    // 흑
                    if ((i + j) % 2 == 0) {
                        visit[i][j] = true;
                        max_B = 1;
                        count_B--;
                        back(i, j, visit, 1, 1);
                        visit[i][j] = false;
                        count_B++;
                    }

                    // 백
                    else {
                        visit[i][j] = true;
                        max_W = 1;
                        count_W--;
                        back(i, j, visit, 1, 1);
                        visit[i][j] = false;
                        count_W++;
                    }
                }
            }
        }


        System.out.println(max_B + max_W);
    }

    static void back(int x, int y, boolean[][] visit, int count, int depth) {

        if ((x + y) % 2 == 0) {
            if (count + count_B <= max_B)
                return;
        } else {
            if(count + count_W <= max_W)
                return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = ((i % 2) == (x + y) % 2 ) ? 0 : 1 ; j < n; j+=2) {
                if (!visit[i][j] && map[i][j] == 1 && isPlaceable(i,j)) {
                    visit[i][j] = true;
                    count_B--;
                    count_W--;
                    back(i, j, visit, count + 1, depth);
                    visit[i][j] = false;
                    count_B++;
                    count_W++;
                }
            }
        }

        if((x+y) %2 ==0)
            max_B = Math.max(max_B, count);
        else
            max_W = Math.max(max_W, count);
    }

    static boolean isPlaceable(int x, int y) {

        for (int i = 0; i < 4; i++) {
            int xx = x + mx[i];
            int yy = y + my[i];

            while (xx >= 0 && yy >= 0 && xx < n && yy < n) {
                if (visit[xx][yy]) {
                    return false;
                }
                xx += mx[i];
                yy += my[i];
            }
        }

        return true;
    }


}


