package BackJoon;

import java.util.Scanner;

// 이친수
public class BOJ2193 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long dp[] = new long[91];

        dp[1] = 1;

        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println(dp[scanner.nextInt()]);
    }
}
