package groupStudy.day08.group;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2670 {

    static int n;
    static Double num[];
    static Double dp[];
    static Double maxValue = 0.0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());

        num = new Double[n];
        dp = new Double[n];

        for (int i = 0; i < n; i++) {
            num[i] = Double.parseDouble(bufferedReader.readLine());
        }

        dp[0] = num[0];

        for (int i = 1; i < dp.length; i++)
        {
            dp[i] = Math.max(num[i], num[i] * dp[i - 1]);
            maxValue = Math.max(maxValue, dp[i]);
        }

        System.out.println(String.format("%.3f", maxValue));
    }
    


}
