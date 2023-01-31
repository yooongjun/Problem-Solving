package SDS.day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 내려가기
public class BOJ2096 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 이전 단계  최댓값
        int a1 = 0, a2 = 0, a3 = 0;

        // 이전 단계 최솟값
        int c1 = 0, c2 = 0, c3 = 0;

        int t1, t2, t3;

        int n = Integer.parseInt(br.readLine());

        for(int i = 1; i  < n + 1 ; i ++) {
            String s[] = br.readLine().split(" ");
            int n1 = Integer.parseInt(s[0]);
            int n2 = Integer.parseInt(s[1]);
            int n3 = Integer.parseInt(s[2]);

            t1 = Math.max(a1, a2) + n1;
            t2 = Math.max(a1, Math.max(a2, a3)) + n2;
            t3 = Math.max(a2, a3) + n3;

            a1 = t1;
            a2 = t2;
            a3 = t3;


            t1 = Math.min(c1,  c2) + n1;
            t2 = Math.min(c1, Math.min(c2, c3)) + n2;
            t3 = Math.min(c2, c3) + n3;

            c1 = t1;
            c2 = t2;
            c3 = t3;
        }



        System.out.println( Math.max( a1, Math.max( a2, a3 ) )+ " "  + Math.min( c1, Math.min( c2, c3) ) );





    }

}
