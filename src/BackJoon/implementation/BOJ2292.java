package BackJoon.implementation;

import java.util.Scanner;

/**
 * 벌집
 */
public class BOJ2292 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 1;
        long val = 1;

        while (val < n) val += 6*cnt++;

        System.out.println(cnt);
    }

}
