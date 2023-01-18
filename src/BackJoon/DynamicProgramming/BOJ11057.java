package BackJoon.DynamicProgramming;

import java.util.Scanner;

// 오르막 수
public class BOJ11057 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int dp[][] = new int[n + 1][10];
        int sum = 10;

        // 한 자릿수 초기화
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        if (n > 1) {

            sum = 55;
            for (int i = 0; i < 10; i++) {
                dp[2][i] = 10 - i;
            }

            for (int i = 3; i < n + 1; i++) {
                int tmp = 0;
                for (int j = 9; j >= 0; j--) {

                    if (j == 9)
                        dp[i][j] = 1;
                    else
                        dp[i][j] = (dp[i - 1][j] + dp[i][j + 1]) % 10007;

                    tmp = (tmp + dp[i][j]) % 10007;
                }
                sum = tmp;
            }
        }
        System.out.println(sum);

    }
}


