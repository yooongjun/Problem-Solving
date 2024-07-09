package BackJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ19951 {

    static int N;
    static int M;
    static int H[];
    static int cal[];

    public static void main(String[] args) throws Exception{
        new BOJ19951().solution();
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        H = new int[N + 1];
        cal = new int[N + 2];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            H[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            cal[a] += k;
            cal[b + 1] -= k;
        }

        int tmp = 0;
        for (int i = 1; i <= N; i++) {
            tmp += cal[i];
            bw.append(H[i] + tmp + " ");
        }


        bw.flush();
        br.close();
        bw.close();

    }
}
