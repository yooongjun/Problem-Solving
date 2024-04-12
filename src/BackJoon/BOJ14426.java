package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 접두사 찾기
public class BOJ14426 {

    static int N, M;
    static String[] s1;
    static String[] s2;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bufferedReader.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        s1 = new String[N];
        s2 = new String[M];

        for (int i = 0; i < N; i++) {
            s1[i] = bufferedReader.readLine();
        }

        for (int i = 0; i < M; i++) {
            s2[i] = bufferedReader.readLine();
        }




    }
}
