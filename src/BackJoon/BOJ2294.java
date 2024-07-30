package BackJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 동전 2
public class BOJ2294 {

    static int n, k;
    static Set<Integer> coinSet = new HashSet<>();
    static List<Integer> coins;
    static int dp[];

    static final int INF = 100000;

    private void solution() throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bufferedReader.readLine().split(" ");

        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);
        dp = new int[10001];

        for (int i = 0; i < n; i++) {
            coinSet.add(Integer.parseInt(bufferedReader.readLine()));
        }

        coins = new ArrayList<>(coinSet);
        Arrays.fill(dp, INF);
        Collections.sort(coins);

        for (int i = 0; i < coins.size(); i++) {
            Integer coin = coins.get(i);
            if (coin <= 10000) {
                dp[coin] = 1;
                for (int j = 1; j <= 10000; j++) {
                    if (j - coin >= 0) {
                        dp[j] = Math.min(dp[j], dp[j - coin] + dp[coin]);
                    }
                }
            }
        }

        System.out.println(dp[k] >= INF ? -1 : dp[k]);
    }

    public static void main(String[] args) throws Exception {
        new BOJ2294().solution();
    }

}
