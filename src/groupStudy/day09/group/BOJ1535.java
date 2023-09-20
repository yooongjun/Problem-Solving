package groupStudy.day09.group;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 안녕
public class BOJ1535 {

    static int n;

    static int price[];
    static int value[];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());

        int dp[] = new int[100];
        price = new int[n];
        value = new int[n];

        String[] input_1 = bufferedReader.readLine().split(" ");
        String[] input_2 = bufferedReader.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            price[i] = Integer.parseInt(input_1[i]);
            value[i] = Integer.parseInt(input_2[i]);
        }


        int max = 0;


        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= 99; j++) {
                if (price[i] + j <= 99) {
                    dp[j + price[i] ] = Math.max(dp[j + price[i]], value[i] + dp[j]);
                }
            }
        }


        for (int i = 0; i < 100; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }


}
