package BackJoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 캡틴 이다솜
public class BOJ1660 {


    static boolean visit[] = new boolean[300001];
    static int dp[] = new int[300001];
    static int N;
    static int min = 300000;
    static int cnt = 0;



    static void makeSum() {
        int increase = 1;
        int sum = 0;
        int dummy = 0;
        List<Integer> list = new ArrayList<>();

        while (sum < 300000) {
            visit[sum] = true;
            dummy += increase++;
            sum += dummy;
        }

        int idx = 0;

        // dp[i] == i개의 대포알을 가지고 있을 때 만들 수 있는 사면체의 최소
        for (int i = 1; i < dp.length; i++) {
            dp[i] = i;

            if (visit[i]) {
                list.add(i);
                idx++;
                dp[i] = 1;
                continue;
            }

            for (int j = 0; j < idx; j++) {

                Integer num = list.get(j);

                dp[i] = Math.min(dp[i - num] + dp[num], dp[i]);
            }
        }
    }

    private void solution() {
        Scanner scanner = new Scanner(System.in);
        N = Integer.parseInt(scanner.nextLine());

        makeSum();

        System.out.println(dp[N]);
    }

    public static void main(String[] args) {
        new BOJ1660().solution();
    }
}
