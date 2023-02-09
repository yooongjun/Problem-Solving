package SDS.day09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 배낭 문제와 비슷한 유형
// 배낭의 제한 무게를 Cost라고 생각하면
// Cost 가 0,1,2 , .. 이런식으로 분할하여 계산
// 앱
public class BOJ7579 {

    static long dp[][] = new long[101][10001];
    // B[1] --> 1번 앱으로 확보 가능한 Byte
    // C[1] --> 1번 앱을 비활성화하면 드는 비용
    static int B[] = new int[101];
    static int C[] = new int[101];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int j = 0; j < 2; j++) {
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <=N; i++) {
                if(j == 0)
                    B[i] = Integer.parseInt(st.nextToken());
                else
                    C[i] = Integer.parseInt(st.nextToken());
            }
        }

        int result = Integer.MAX_VALUE;

        // dp[I][J] : I번째 앱을 고려했을 때, 비용이 J인 경우 확보하는 최대의 바이트
        for(int i = 1; i <= N; i++) {
            for(int j = 0; j <= 10000; j++ )
            {
                // 현재 기준 cost를 초과하면 넣지 않고 기존의 값 유지
                if( C[i] > j) {
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - C[i]] + B[i]);

                    if(dp[i][j] >= M)
                    {
                        result = Math.min(result, j);
                    }
                }
            }
        }

        System.out.println(result);




    }

}
