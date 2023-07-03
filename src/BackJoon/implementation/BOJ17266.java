package BackJoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 어두운 굴다리
 */
public class BOJ17266 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        int m = Integer.parseInt(bufferedReader.readLine());

        int arr[] = new int[m + 1];

        String[] s = bufferedReader.readLine().split(" ");
        int light = Integer.MIN_VALUE;

        for (int i = 1; i <= m; i++) {
            arr[i] = Integer.parseInt(s[i - 1]);
        }

        light = Math.max(arr[1], n - arr[m]);

        for (int i = 2; i <= m; i++)
        {
            int tmp = (arr[i] + arr[i-1])/2;
            tmp = Math.max(tmp - arr[i-1], arr[i] - tmp);
            light = Math.max(tmp, light);
        }

        System.out.println(light);
    }

}
