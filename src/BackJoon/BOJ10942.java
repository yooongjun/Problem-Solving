package BackJoon;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ10942 {

    static int N;
    static int M;
    static int arr[];

    static boolean dp[][];

    boolean isPalindrome(int start, int end) {

        while (start <= end) {
            if (arr[start++] != arr[end--]) {
                return false;
            }
        }

        return true;
    }


    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        dp = new boolean[N + 1][N + 1];

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i + 1] = Integer.parseInt(stringTokenizer.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (isPalindrome(i, j)) {
                    dp[i][j] = true;
                }
            }
        }

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            String[] query = br.readLine().split(" ");
            int a = Integer.parseInt(query[0]);
            int b = Integer.parseInt(query[1]);

            bw.append((isPalindrome(a, b) ? 1 : 0 )+ "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    public static void main(String[] args) throws Exception{
        new BOJ10942().solution();
    }

}
