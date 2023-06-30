package BackJoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 스위치 켜고 끄기
 */
public class BOJ1244 {

    static int n;
    static int arr[];
    static int student;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());
        arr = new int[n + 1];
        String[] s = bufferedReader.readLine().split(" ");
        for (int i = 1; i <= n; i++) { arr[i] = Integer.parseInt(s[i - 1]); }
        student = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < student; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            int a ,b;
            a = Integer.parseInt(input[0]);
            b = Integer.parseInt(input[1]);
            func(a,b);
        }

        for (int i = 1; i < arr.length; i++) {

            if (i >= 20 && i % 20 == 0) {
                System.out.println(arr[i]);
                continue;
            }
            System.out.print(arr[i] + " ");
        }
    }

    static void changeState(int idx) {
        if(arr[idx] == 1)
            arr[idx] = 0;
        else
            arr[idx] = 1;
    }

    static void func(int a, int b) {

        // 남자
        if (a == 1) {

            for (int i = 1; i < arr.length; i++) {
                if (i % b == 0 && i >= b) {
                    changeState(i);
                }
            }

        }

        if (a == 2) {
            int tmp = 0;
            while (true) {
                int left = b - tmp;
                int right = b + tmp;

                if (left < 1 || right >= arr.length || arr[left] != arr[right]) {
                    tmp--;
                    break;
                }

                tmp++;
            }

            for (int i = b - tmp; i <= b + tmp; i++) {
                changeState(i);
            }
        }
    }

}
