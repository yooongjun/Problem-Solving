package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 경로 찾기
public class BOJ11403 {

    static int adj[][];
    static int N;

    static final int INF = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bufferedReader.readLine());

        adj = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            Arrays.fill(adj[i], INF);
        }

        for (int i = 1; i <= N; i++) {
            String[] s = bufferedReader.readLine().split(" ");
            for (int j = 1; j <= N; j++) {
                int tmp = Integer.parseInt(s[j - 1]);
                adj[i][j] = (tmp == 0) ? INF : tmp;
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    adj[j][k] = Math.min(adj[j][k], adj[j][i] + adj[i][k]);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print( ((adj[i][j] == INF) ? 0 : 1) + " ");
            }
            System.out.println();
        }

    }

}
