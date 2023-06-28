package BackJoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 줄 세우기
 */
public class BOJ10431 {

    static int p;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        p = Integer.parseInt(bufferedReader.readLine());

        for (int t = 1; t <= p; t++) {
            String[] s = bufferedReader.readLine().split(" ");

            int[] arr = new int[20];
            int result = 0;

            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(s[i + 1]);
                for (int j = i; j >= 0; j--) {
                    if(arr[i] < arr[j]) result++;
                }
            }

            System.out.println(t + " " + result);
        }

    }

}
