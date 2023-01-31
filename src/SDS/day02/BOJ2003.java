package SDS.day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 수들의 합
public class BOJ2003 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        long m = Long.parseLong(s[1]);
        int cnt = 0;
        int arr[] = new int[n + 1];
        long sum[] = new long[n + 1];


        s = br.readLine().split(" ");
        for(int i=1; i < arr.length; i++) {
            arr[i] = Integer.parseInt(s[i-1]);
            sum[i] = arr[i] + sum[i-1];
        }

        int p1, p2;


        for(int i=0; i < sum.length; i++) {
            for(int j=i+1; j < sum.length; j++) {
                if(sum[j] - sum[i] > m)
                    break;

                if(sum[j] - sum[i] == m)
                    cnt++;

            }
        }


        System.out.println(cnt);






    }

}
