package BackJoon.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * List of Unique Numbers
 */
public class BOJ13144 {

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());

        int dt[] = new int[n+1];
        // 입력 받기
        String s[] = bufferedReader.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            dt[i] = Integer.parseInt(s[i - 1]);
        }

        long result = 0;
        int end = 1;
        boolean visit[] = new boolean[100001];

        for (int start = 1; start <= n; start++) {

            while (end <= n && !visit[dt[end]]) {
                visit[dt[end]] = true;
                end++;
            }

            result += end - start;
            visit[dt[start]] = false;

        }

        System.out.println(result);
    }

}
