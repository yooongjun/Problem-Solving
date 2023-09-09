package groupStudy.day08.group;

import java.util.Scanner;

/**
 * 설탕 배달
 */
public class BOJ2839 {

    static int N;
    static int dp[] = new int[5001];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();

        dp[1] = -1;
        dp[2] = -1;
        dp[3] = 1;
        dp[4] = -1;
        dp[5] = 1;

        for (int i = 6; i <= 5000; i++) {
            if (dp[i - 3] == -1 && dp[i - 5] == -1) {
                dp[i] = -1;
                continue;
            }

            dp[i] = Math.min( (dp[i - 3] != -1 ? dp[i - 3] : 10000) + dp[3], ( dp[i - 5] != -1 ? dp[i - 5] : 10000 ) + dp[5]);
        }
        System.out.println(dp[N]);
    }

}
