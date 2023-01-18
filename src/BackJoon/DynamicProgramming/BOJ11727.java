package BackJoon.DynamicProgramming;

import java.util.Scanner;

// 2×n 타일링 2
public class BOJ11727 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        long dp[] = new long[n + 1];
        dp[1] = 1;

        if (n >= 2) {

            dp[2] = 3;

            for (int i = 3; i <= n; i++) {
                dp[i] = (2 * dp[i - 1] + (i % 2 == 0 ? 1 : -1)) % 10007;
            }

        }
        System.out.println(dp[n]);
    }

}
