package BackJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 피아노 체조
public class BOJ21318 {

    static int prefixSum[];
    static int N, Q;

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        String[] s = br.readLine().split(" ");
        prefixSum = new int[N + 1];
        prefixSum[1] = 0;

        for (int i = 1; i < N; i++) {
            int a = Integer.parseInt(s[i - 1]);
            int b = Integer.parseInt(s[i]);

            prefixSum[i + 1] = prefixSum[i] + ((a > b) ? 1 : 0);
        }

        Q = Integer.parseInt(br.readLine());

        for (int i = 0; i < Q; i++) {
            String[] input = br.readLine().split(" ");
            int from = Integer.parseInt(input[0]);
            int to = Integer.parseInt(input[1]);
            bw.append(prefixSum[to] - prefixSum[from] + "\n");
        }

        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new BOJ21318().solution();
    }

}
