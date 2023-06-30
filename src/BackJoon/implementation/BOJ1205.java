package BackJoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

/**
 * 등수 구하기
 */
public class BOJ1205 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n , score, p;

        String[] s = bufferedReader.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        score = Integer.parseInt(s[1]);
        p = Integer.parseInt(s[2]);

        if (n == 0) {
            System.out.println(1);
            return;
        }

        Integer arr[] = new Integer[n+1];
        String[] input = bufferedReader.readLine().split(" ");

        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        arr[n] = score;

        Arrays.sort(arr, Collections.reverseOrder());

        int rank = 1;
        int cnt = 1;
        int answer = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] > score) {
                cnt++;
                rank++;
                continue;
            }

            if (score == arr[i]) {
                while (i < arr.length - 1 ) {
                    if (arr[i + 1] != score) {
                        break;
                    }
                    cnt++;
                    i++;
                }
                answer = rank;
                break;
            }
        }

        if (cnt <= p) {
            System.out.println(answer);
        }
        else
            System.out.println(-1);
    }
}
