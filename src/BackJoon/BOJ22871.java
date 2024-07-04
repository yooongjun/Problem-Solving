package BackJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 징검다리 건너기(large)
public class BOJ22871 {

    static long[] dp = new long[5001];
    static int[] A = new int[5001];
    static int N;

    private void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = 0;

        for (int i = 2; i <= N; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j < i; j++) {
                dp[i] = Math.min(dp[i], Math.max(dp[j], (long) (i - j) * (1 + Math.abs(A[i] - A[j]))));
            }
        }

        System.out.println(dp[N]);

    }

    public static void main(String[] args) throws Exception{
        new BOJ22871().solution();
    }
}
