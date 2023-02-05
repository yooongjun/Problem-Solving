package SDS.day05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ5557 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String s[] = br.readLine().split(" ");
        int num[] = new int[N+1];
        long[][] dp = new long[N+1][21];

        for (int i = 1; i <= N; i++) {
            num[i] = Integer.parseInt(s[i-1]);
        }

        dp[1][num[1]] = 1;

        for(int i= 2; i < N; i++){

            for (int j= 0; j <=20; j++){

                if((j-num[i] >= 0) && (j + num[i] <= 20))
                    dp[i][j] = dp[i-1][j + num[i]] + dp[i-1][j -num[i]];
                else {
                    if(( j - num[i] < 0)){
                        dp[i][j] = dp[i-1][j + num[i]];
                    }
                    else{
                        dp[i][j] = dp[i-1][j - num[i]];
                    }
                }

            }

        }


        System.out.println(dp[N-1][num[N]]);

    }

}
