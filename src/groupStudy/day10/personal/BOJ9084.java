package groupStudy.day10.personal;

import java.io.*;

public class BOJ9084 {



    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(bufferedReader.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(bufferedReader.readLine());
            int coins[] = new int[n];
            String[] s = bufferedReader.readLine().split(" ");

            for (int i = 0; i < n; i++) {
                coins[i] = Integer.parseInt(s[i]);
            }

            int M = Integer.parseInt(bufferedReader.readLine());

            int dp[] = new int[M + 1];
            dp[0] = 1;
            for (int i = 0; i < coins.length; i++) {
                for (int j = coins[i]; j < dp.length; j++) {
                    dp[j] += dp[j - coins[i]];
                }
            }

            bufferedWriter.append(dp[M] + "\n");
        }
        bufferedWriter.flush();
    }


}
