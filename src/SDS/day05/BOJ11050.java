package SDS.day05;

import java.util.Scanner;

public class BOJ11050 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        System.out.println(nCk(n, k));

    }

    public static long nCk(int n, int k) {

        long a = 1;
        long b = 1;

        for(int i=0; i < k; i++) {
            a *= (n-i);
        }

        for(int i=k; i > 0; i--) {
            b *= i;
        }

        return a/b;
    }

}
