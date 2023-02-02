package SDS.day04;

import java.util.Scanner;

// 1
public class BOJ4375 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()) {
            int num = sc.nextInt();
            System.out.println(func(1, 1 % num, num));
        }

    }

    static int func(int x, int n, int m){

        if (n == 0)
            return x;

        else {
            return func(x+1, (10 * n + 1) % m, m );
        }
    }

}
