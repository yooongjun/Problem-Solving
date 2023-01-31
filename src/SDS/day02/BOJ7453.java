package SDS.day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ7453 {

    static int A[],B[],C[],D[];
    static long[] AB, CD;
    static long cnt = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st ;
        A = new int[n];
        B = new int[n];
        C = new int[n];
        D = new int[n];

        for(int i=0; i < n; i++)
        {
            st = new StringTokenizer(br.readLine());

            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }



        AB = new long[n*n];
        CD = new long[n*n];

        int idx = 0;

        for(int i=0; i < n; i++) {
            for(int j=0; j< n; j++) {
                AB[idx] = A[i] + B[j];
                CD[idx] = C[i] + D[j];
                idx++;
            }
        }

        Arrays.sort(AB);
        Arrays.sort(CD);

        tp();

        System.out.println(cnt);


    }


    static void tp() {

        int i = 0;
        int j = CD.length - 1;

        while(i < AB.length && j >= 0) {


            long sum = AB[i] + CD[j];

            if(sum == 0) {
                long cnt1 = 0;
                long cnt2 = 0;
                long t1 = AB[i], t2 = CD[j];

                while(i < AB.length && AB[i] == t1) {
                    cnt1++;
                    i++;
                }

                while(j >= 0 && CD[j] == t2) {
                    cnt2++;
                    j--;
                }
                cnt += cnt1 * cnt2;
            }

            if(sum > 0) {
                j--;
            }
            if(sum < 0) {
                i++;
            }

        }







    }


}
