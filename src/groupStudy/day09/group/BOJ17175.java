package groupStudy.day09.group;

import java.util.Scanner;

/**
 * 피보나치는 지겨웡 ~
 */
public class BOJ17175 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        long dp[] = new long[51];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 3;

        for (int i = 3; i <= 50; i++) {
            dp[i] =  dp[i-1] + dp[i-2] + 1;
        }

        System.out.println(dp[n] );
    }
}

