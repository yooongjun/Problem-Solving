package BackJoon.implementation;

import java.util.Scanner;

/**
 * ZOAC 4
 */
public class BOJ23971 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w,h,n,m;

        h = sc.nextInt();
        w = sc.nextInt();
        n = sc.nextInt() + 1;
        m = sc.nextInt() + 1;

        System.out.println(((h % n == 0)?h/n: (h/n+1)) * ((w%m==0)?w/m:(w/m+1)));
    }

}
