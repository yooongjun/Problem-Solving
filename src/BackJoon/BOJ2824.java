package BackJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 최대 공약수
public class BOJ2824 {

    int N, M;
    int[] A, B;
    long answer = 1;

    private int findGcd(int a, int b){

        while (b > 0) {
            if (b > a) {
                int tmp = b;
                b = a;
                a = tmp;
            }

            int c = a % b;
            a = b;
            b = c;
        }

        return a;
    }

    private void solution() throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        boolean flag = false;

        N = Integer.parseInt(bufferedReader.readLine());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        M = Integer.parseInt(bufferedReader.readLine());
        stringTokenizer =  new StringTokenizer(bufferedReader.readLine());
        B = new int[M];
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int gcd = findGcd(A[i], B[j]);
                answer *= gcd;

                if (answer > 99999999) {
                    flag = true;
                    answer %= 1000000000;
                }

                A[i] /= gcd;
                B[j] /= gcd;
            }
        }

        String result = String.valueOf(answer);
        StringBuilder stringBuilder = new StringBuilder();

        if (flag) {
            for (int i = 0; i < 9 - result.length(); i++) {
                stringBuilder.append('0');
            }
        }

        stringBuilder.append(result);
        System.out.println(stringBuilder.toString());
        bufferedReader.close();
    }

    public static void main(String[] args) throws Exception {
        new BOJ2824().solution();
    }


}
