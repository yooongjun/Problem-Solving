package BackJoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * RGB거리 2
 */

public class BOJ17404 {


    static int dp_r[][], dp_g[][], dp_b[][];
    static int n;

    static final int INF = 10000000;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());

        // 2차원 배열의 각각 행은 1번 집을 어떤 색으로 칠했는지를 나타낸다.
        // 즉, 0행은 R, 1행은 G, 2행은 B로 1번 집을 색칠했다는 것이다.
        dp_r = new int[3][n+1];
        dp_g = new int[3][n+1];
        dp_b = new int[3][n+1];

        // 칠하는 비용으로 0행은 R, 1행은 G, 2행은 B로 칠하는 비용을 저장
        int[][] dt = new int[3][n+1];

        for (int i = 1; i <= n; i++) {
            String[] s = bufferedReader.readLine().split(" ");

            dt[0][i] = Integer.parseInt(s[0]); // R로 칠하는 비용
            dt[1][i] = Integer.parseInt(s[1]); // G로 칠하는 비용
            dt[2][i] = Integer.parseInt(s[2]); // B로 칠하는 비용
        }

        
        // dp 초깃값 갱신
        // 0행: 1번째 집을 R로 색칠하는 경우이므로 다른 색으로 칠하는 비용은 INF로 처리
        dp_r[0][1] = dt[0][1];
        dp_g[0][1] = INF;
        dp_b[0][1] = INF;

        // G로 출발하는 경우
        dp_r[1][1] = INF;
        dp_g[1][1] = dt[1][1];
        dp_b[1][1] = INF;

        // B로 출발하는 경우
        dp_r[2][1] = INF;
        dp_g[2][1] = INF;
        dp_b[2][1] = dt[2][1];


        int result = INF;


        for (int i = 0; i < 3; i++) {

            // 기본 점화식을 사용하여 n-1번 집까지의 최소 색칠 비용을 구함
            for (int j = 2; j <= n - 1; j++) {

                dp_r[i][j] = Math.min(dp_g[i][j - 1], dp_b[i][j - 1]) + dt[0][j];
                dp_g[i][j] = Math.min(dp_r[i][j - 1], dp_b[i][j - 1]) + dt[1][j];
                dp_b[i][j] = Math.min(dp_g[i][j - 1], dp_r[i][j - 1]) + dt[2][j];

            }

            // 마지막 n번째 집을 색칠할 때는 1번 집의 색(2차원 배열의 행)을 고려해 같은 색인 경우 INF로 처리함
            dp_r[i][n] = Math.min(dp_g[i][n - 1], dp_b[i][n - 1]) + ((i == 0) ? INF : dt[0][n]);
            dp_g[i][n] = Math.min(dp_r[i][n - 1], dp_b[i][n - 1]) + ((i == 1) ? INF : dt[1][n]);
            dp_b[i][n] = Math.min(dp_g[i][n - 1], dp_r[i][n - 1]) + ((i == 2) ? INF : dt[2][n]);

            // 최솟값 구하기
            result = Math.min(result, Math.min(dp_r[i][n], Math.min(dp_g[i][n], dp_b[i][n])));
        }

        // 결과 출력
        System.out.println(result);
    }


}
