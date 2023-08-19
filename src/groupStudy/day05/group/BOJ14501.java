package groupStudy.day05.group;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 퇴사
 */
public class BOJ14501 {

    static int N;
    static int time[];
    static int profit[];

    static int maxProfit = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bufferedReader.readLine());

        time = new int[N + 1];
        profit = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            String s[] = bufferedReader.readLine().split(" ");
            time[i] = Integer.parseInt(s[0]);
            profit[i] = Integer.parseInt(s[1]);
        }

        System.out.println(findMax());
    }

    private static int findMax() {
        bf(1, 0);
        return maxProfit;
    }

    private static void bf(int today, int value) {

        if(today > N + 1) return;

        maxProfit = ((today == N) && time[N] == 1) ? Math.max(maxProfit, value + profit[N]) : Math.max(maxProfit, value);

        for (int i = today; i <= N; i++) {
            bf(i + time[i], value + profit[i]);
        }


    }
}
