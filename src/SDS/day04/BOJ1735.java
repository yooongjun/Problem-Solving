package SDS.day04;

import java.util.Scanner;

public class BOJ1735 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int b1 = sc.nextInt();
        int a1 = sc.nextInt();
        int b2 = sc.nextInt();
        int a2 = sc.nextInt();

        // 분수의 합
        int n = a1 * a2;
        int m = a1 * b2 + a2 * b1;


        int t =gcd(Math.max(n,m ), Math.min(n, m));

        System.out.println(m/t +" " + n/t);

    }

    // a > b
    static int gcd(int a, int b) {

        if(b == 0)
            return a;
        else
            return gcd(b, a%b);
    }
}
