package SDS.day05;

import java.util.Scanner;

public class BOJ1010 {

    static long[][] d = new long[30][30];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        d[1][0] = 1;
        d[1][1] = 1;

        for(int i=2; i< 30; i++) {
            d[i][0] = 1;
            for(int j=1; j<=i; j++)
                d[i][j] = d[i-1][j-1] + d[i-1][j];
        }

        int x = sc.nextInt();

        for(int i=0; i < x; i++)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            System.out.println(d[m][n]);
        }

    }



}
