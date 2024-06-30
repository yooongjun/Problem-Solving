package BackJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ22857 {

    static int N, K;
    static int max = 0;
    static int num[];
    static int count[];
    static int length[];

    private void solution() throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        K = Integer.parseInt(stringTokenizer.nextToken());

        num = new int[N + 1];
        count = new int[N + 1];
        length = new int[N + 1];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            num[i + 1] = Integer.parseInt(stringTokenizer.nextToken());
        }

        length[1] = num[1] % 2 == 0 ? 1 : 0;
        count[1] = num[1] % 2 == 0 ? 0 : 1;

        for (int i = 2; i <= N; i++) {
            length[i] = length[i - 1] + (num[i] % 2 == 0 ? 1 : 0);
            count[i] = count[i - 1] + (num[i] % 2 == 0 ? 0 : 1);
        }

        for (int i = 0; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (count[j] - count[i] <= K) {
                    max = Math.max(max, length[j] - length[i]);
                }
            }
        }

        System.out.println(max);
    }


    public static void main(String[] args) throws Exception {
        new BOJ22857().solution();
    }


}
