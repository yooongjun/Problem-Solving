package BackJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

// 가장 큰 증가하는 부분 수열
public class BOJ11055 {

    static int N , result = 0;
    static int A[];
    static int sum[];

    private void solution() throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        A = new int[N];
        sum = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        sum[0] = A[0];

        for (int i = 1; i < N; i++) {
            sum[i] = A[i];
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j]) {
                    sum[i] = Math.max(sum[i], sum[j] + A[i]);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            result = Math.max(result, sum[i]);
        }

        System.out.println(result);
    }

    public static void main(String[] args) throws Exception {
        new BOJ11055().solution();
    }
}
