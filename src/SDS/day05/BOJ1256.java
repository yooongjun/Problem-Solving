package SDS.day05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ1256 {


    static long paskal[][] = new long[201][201];
    static int n, m, k;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");

        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        k = Integer.parseInt(s[2]);

        paskal[1][0] = 1;
        paskal[1][1] = 1;

        for(int i = 2; i <= n + m; i++) {
            paskal[i][0] = 1;
            for(int j = 1; j <= i; j++) {
                paskal[i][j] = paskal[i-1][j-1] + paskal[i-1][j];

                if(paskal[i][j] > 1000000000) {
                    paskal[i][j] = 1000000001;
                }
            }
        }

        findString();

        // 결과 출력
        bw.flush();
    }

    static void findString() throws IOException{


        if(paskal[n+m][n] < k)
        {
            bw.append("-1");
            return;
        }

        while(true) {

            if(n==0 || m ==0)
            {
                while(n>0)
                {
                    bw.append('a');
                    n--;
                }

                while(m>0)
                {
                    bw.append('z');
                    m--;
                }
                break;
            }

            if(n > 0 && ( paskal[n+m -1][n -1] >= k ) )
            {
                bw.append('a');
                n--;
            }
            else {
                bw.append('z');
                if(n > 0)
                    k -= paskal[n+m-1][n -1];
                m--;
            }
        }
    }





}
