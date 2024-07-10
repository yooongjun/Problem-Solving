package BackJoon;

import java.util.Scanner;

// 홀수 홀릭 호석
public class BOJ20164 {

    static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    static String N;

    static void back(String s, int cnt) {

        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) - '0') % 2 != 0) {
                cnt += 1;
            }
        }

        if (s.length() <= 1) {
            min = Math.min(min, cnt);
            max = Math.max(max, cnt);
            return;
        }

        for (int i = 1; i < s.length(); i++) {
            String next = "";

            if (s.length() >= 3) {
                for (int j = i + 1; j < s.length(); j++) {
                    next = String.valueOf(Integer.parseInt(s.substring(0, i)) + Integer.parseInt(s.substring(i, j)) + Integer.parseInt(s.substring(j, s.length())));
                    back(next, cnt);
                }
            }
            else {
                next = String.valueOf(Integer.parseInt(s.substring(0, i)) + Integer.parseInt(s.substring(i, s.length())));
                back(next, cnt);
            }

        }
    }

    private void solution() throws Exception {
        Scanner sc = new Scanner(System.in);

        N = sc.nextLine();

        back(N, 0);

        System.out.println(min + " " + max);

    }

    public static void main(String[] args) throws Exception {
        new BOJ20164().solution();
    }

}
