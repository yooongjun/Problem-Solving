package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

// 합이 0인 네 정수
public class BOJ7453 {

    static  int A[], B[], C[], D[];
    static int AB[], CD[];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());

        A = new int[n];
        B = new int[n];
        C = new int[n];
        D = new int[n];

        AB = new int[n * n];
        CD = new int[n * n];

        long result = 0;

        for(int i=0; i < n; i++)
        {
            String s[] = bufferedReader.readLine().split(" ");
            A[i] = Integer.parseInt(s[0]);
            B[i] = Integer.parseInt(s[1]);
            C[i] = Integer.parseInt(s[2]);
            D[i] = Integer.parseInt(s[3]);
        }


        int idx = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                AB[idx] = A[i] + B[j];
                CD[idx] = C[i] + D[j];
                idx++;
            }
        }


        Arrays.sort(AB);
        Arrays.sort(CD);

        int l = 0;
        int r = CD.length - 1;

        while (l < AB.length && r >= 0) {

            int sum = AB[l] + CD[r];

            if (sum > 0) {
                r--;
            }

            if (sum < 0) {
                l++;
            }

            if (sum == 0) {
                long cnt1 = 0, cnt2 = 0;
                int t1 = AB[l];
                int t2 = CD[r];

                while (l < AB.length && t1 == AB[l]) {
                    cnt1++;
                    l++;
                }

                while (r >= 0 && t2 == CD[r]) {
                    cnt2++;
                    r--;
                }

                result += cnt1 * cnt2;
            }
        }


        System.out.println(result);
    }

}
