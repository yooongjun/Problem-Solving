package groupStudy.day05.group;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 토너먼트
 */
public class BOJ1057 {

    static int jimin, hansoo;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bufferedReader.readLine().split(" ");

        int N = Integer.parseInt(s[0]);

        jimin = Integer.parseInt(s[1]);
        hansoo = Integer.parseInt(s[2]);
        int round = 1;

        while (jimin > 0 && hansoo > 0) {

            if (isMatched(jimin, hansoo)) {
                break;
            }

            jimin = jimin % 2 == 0 ? jimin / 2 : jimin / 2 + 1;
            hansoo = hansoo % 2 == 0 ? hansoo / 2 : hansoo / 2 + 1;

            round++;
        }

        System.out.println(round);
    }

    static  boolean isMatched(int A, int B) {

        if (A > B) {
            int tmp = B;
            B = A;
            A = tmp;
        }

        if(A % 2 != 0 && B == A + 1) return true;

        return false;
    }

}
