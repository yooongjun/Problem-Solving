package silverRandomDefence;

import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 가장 긴 증가하는 부분 수열 4
 */
public class BOJ14002 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        int arr[] = new int[N + 1];
        int dp[] = new int[N + 1];
        int order[] = new int[N + 1];

        String[] s = bufferedReader.readLine().split(" ");

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(s[i - 1]);
        }

        Arrays.fill(dp, 1);

        for (int i = 2; i <= N; i++) {
            int now = arr[i];
            int maxIdx = i;

            for (int j = 1; j < i; j++) {

                if(now > arr[j]){
                    if (dp[maxIdx] <= dp[j]) {
                        dp[i] = dp[j] + 1;
                        maxIdx = j;
                        order[i] = j;
                    }
                }

            }
        }

        int max = 0;
        int idx = 0;

        for (int i = 1; i <= N; i++) {

            if (max < dp[i]) {
                max = dp[i];
                idx = i;
            }

        }

        List<Integer> result = new ArrayList<>();

        for (int i = max; i > 0; i--) {
            result.add(arr[idx]);
            idx = order[idx];
        }


        System.out.println(max);

        for (int i = result.size() - 1; i >= 0; i--) {

            System.out.print(result.get(i) + " ");
        }
    }


}
