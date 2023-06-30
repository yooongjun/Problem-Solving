package BackJoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 쿠키의 신체 측정
 */
public class BOJ20125 {

    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int heart_x = 0, heart_y = 0;
        int l_arm = 0, r_arm = 0, waist = 0, l_leg = 0, r_leg = 0;

        map = new char[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            String s = bufferedReader.readLine();
            for (int j = 1; j <= n; j++) {
                char c = s.charAt(j - 1);
                map[i][j] = c;

                if (heart_x == 0 && heart_y == 0 && c == '*') {
                    heart_x = i + 1;
                    heart_y = j;
                    continue;
                }

                if (c == '*') {
                    if (i == heart_x &&  j < heart_y && l_arm == 0) {
                        l_arm = heart_y - j;
                    }

                    if (i == heart_x && j > heart_y) {
                        r_arm = j - heart_y;
                    }

                    if (j == heart_y && i > heart_x) {
                        waist++;
                    }

                    if (i > heart_x && j < heart_y) {
                        l_leg++;
                    }

                    if (i > heart_x && j > heart_y) {
                        r_leg++;
                    }
                }
            }
        }

        System.out.println(heart_x + " " + heart_y);
        System.out.println(l_arm + " " + r_arm + " " + waist + " " + l_leg + " " + r_leg);
    }

}
