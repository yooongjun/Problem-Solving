package SDS.day05;

import java.util.Scanner;

public class BOJ11051 {

    static long arr[][] = new long [1001][1001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        arr[1][0] = 1;
        arr[1][1] = 1;
        arr[2][0] = 1;
        arr[2][1] = 2;
        arr[2][2] = 1;

        for(int i=3; i <= n; i++) {
            arr[i][0] = 1;
            for(int j = 1; j <= i; j++) {
                arr[i][j] = ( arr[i-1][j -1 ] + arr[i-1][j] ) % 10007;
            }
        }




        System.out.println(arr[n][k]);


    }

}
