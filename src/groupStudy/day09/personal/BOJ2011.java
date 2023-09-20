package groupStudy.day09.personal;

import java.util.Scanner;

public class BOJ2011 {

    static int dp[];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        dp = new int[input.length() + 1];

        dp[0] = 1;

        for(int i=1; i<=input.length(); i++) {
            int now = input.charAt(i-1) - '0';
            if(now >= 1 && now <= 9) {
                dp[i] += dp[i-1];
                dp[i] %= 1000000;
            }

            if(i == 1) continue;

            int prev = input.charAt(i-2) - '0';

            if(prev == 0) continue;

            int value = prev*10+now;

            if(value >= 10 && value <= 26) {
                dp[i] += dp[i-2];
                dp[i] %= 1000000;
            }
        }
        System.out.println(dp[input.length()]);

    }


}
