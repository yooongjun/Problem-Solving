package silverRandomDefence;

import java.io.*;

/**
 * 시간복잡도
 */
public class BOJ11332 {

    static long[] factorial;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int c = Integer.parseInt(bufferedReader.readLine());

        factorial = new long[10001];

        factorial[1] = 1;
        factorial[2] = 2;
        int lastIdx = -1;

        System.out.println(Math.pow(2,30));

        for (int i = 3; i < factorial.length; i++) {

            factorial[i] = factorial[i - 1] * i;

            if (factorial[i] > 1000000000) {
                lastIdx = i - 1;
                break;
            }
        }

        while (c-- > 0) {
            String[] s = bufferedReader.readLine().split(" ");
            String bigO = s[0];
            long N = Long.parseLong(s[1]);
            long T = Long.parseLong(s[2]);
            long L = Long.parseLong(s[3]);

            if ( isTLE(bigO, N, T, L) )
                bufferedWriter.append("TLE!\n");
            else
                bufferedWriter.append("May pass.\n");
        }

        bufferedWriter.flush();
    }

    static boolean isTLE(String bigO, long N, long T, long L) {
        boolean isTLE = false;

        switch (bigO) {

            case "O(N)":
                if( (N * T) > L * 100000000)
                    isTLE = true;
                break;

            case "O(N^2)":
                if ( N * N * T > L * 100000000)
                    isTLE = true;
                break;

            case "O(N^3)":
                if( N * N * N * T > L * 100000000)
                    isTLE = true;
                break;

            case "O(2^N)":
                if( Math.pow(2, N) * T > L * 100000000 )
                    isTLE = true;
                break;
            case "O(N!)":
                if ( N > 12 )
                    isTLE = true;
                else
                    if(factorial[(int)N] * T > L * 100000000)
                        isTLE = true;

                break;
        }


        return isTLE;
    }

}

