package SDS.day08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 가장 큰 정사각형
 * dp[i][j] --> 해당 위치 가장 큰 정사각형의 오른쪽 맨 아래좌표
 */
public class BOJ1915 {

    static int n, m;
    static int arr[][];
    static int max = 0;
    static int D[][];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");

        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        arr = new int[n+1][m+1];
        D = new int[n+1][m+1];

        for(int i = 1; i < n + 1; i++)
        {
            String input = br.readLine();
            for(int j = 1; j < m+1; j++) {
                arr[i][j] = input.charAt(j - 1) - '0';
                D[i][j] = arr[i][j];
            }
        }



        for(int i = 1; i < n+1; i++) {
            for(int j =1; j < m+1; j++) {
                if(D[i][j] == 1)
                {
                    D[i][j] = Math.min(D[i-1][j], Math.min(D[i][j-1], D[i-1][j-1])) + 1;
                    max = Math.max(D[i][j], max);
                }
            }
        }

        System.out.println(max * max);

    }

}
