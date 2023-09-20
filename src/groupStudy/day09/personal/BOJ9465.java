package groupStudy.day09.personal;

import java.io.*;

public class BOJ9465 {

    static int dp[][];
    static int t;
    static int map[][];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        t = Integer.parseInt(bufferedReader.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(bufferedReader.readLine());
            map = new int[2][n + 1];

            for (int i = 0; i < 2; i++) {
                String[] s = bufferedReader.readLine().split(" ");
                for (int j = 1; j <= n; j++) {
                    map[i][j] = Integer.parseInt(s[j - 1]);
                }
            }
            int result = func(n);
            bufferedWriter.append(result + "\n");
        }

        bufferedWriter.flush();
    }

    static int func(int n) {
        int dp[][] = new int[2][n + 1];

        dp[0][1] = map[0][1];
        dp[1][1] = map[1][1];

        for (int i = 2; i <= n; i++) {
            dp[0][i] = map[0][i] + Math.max(dp[1][i - 1], dp[1][i - 2]);
            dp[1][i] = map[1][i] + Math.max(dp[0][i - 1], dp[0][i - 2]);
        }

        return Math.max(dp[0][n],dp[1][n]);
    }

}
