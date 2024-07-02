package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 사과나무
public class BOJ20002 {

    static int N;
    static int map[][];
    static int value[][];

    static int max = -1000 * 90000;

    private void solution() throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bufferedReader.readLine());

        map = new int[N + 1][N + 1];
        value = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                value[i][j] = map[i][j] + value[i - 1][j] + value[i][j - 1] - value[i - 1][j - 1];
            }
        }

        // K * K인 범위에서 최댓값 찾기
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if ((i >= k) && (j >= k)) {
                        max = Math.max(max, value[i][j] - value[i - k][j] - value[i][j - k] + value[i - k][j - k]);
                    }
                }
            }
        }

        System.out.println(max);
    }

    public static void main(String[] args) throws IOException {
        new BOJ20002().solution();
    }

}
