package BackJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2467 {

    static int N;
    static int arr[];
    static int min = Integer.MAX_VALUE;
    static int[] result = new int[2];

    private void findValue() {
        int left = 0;
        int right = N - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (Math.abs(sum) <= min) {
                min = Math.abs(sum);
                result[0] = arr[left];
                result[1] = arr[right];
            }

            if (sum < 0) {
                left++;
            }
            else{
                right--;
            }
        }
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        findValue();

        System.out.println(result[0] + " " + result[1]);
    }

    public static void main(String[] args) throws Exception {
        new BOJ2467().solution();
    }
}
