package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 가타 레슨
public class BOJ2343 {

    static int N;
    static int M;

    static int lecture[];
    static int max = 0;
    static long sum;
    static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s[] = bufferedReader.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        lecture = new int[N];
        String[] input = bufferedReader.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            lecture[i] = Integer.parseInt(input[i]);
            sum += lecture[i];
            max = Math.max(max, lecture[i]);
        }
        result = sum;
        binarySearch();

        System.out.println(result);
    }

    static void binarySearch() {
        long l = max;
        long r = sum;

        while (l <= r) {
            long mid = (l+r)/2;
            long sum = 0;
            int cnt = 1;

            for (int i = 0; i < N; i++) {
                sum += lecture[i];

                if (sum > mid) {
                    sum = lecture[i];
                    cnt++;
                }

            }

            if (cnt > M) {
                l = mid + 1;
            } else{
                r = mid - 1;
                result = Math.min(mid, result);
            }
        }

    }

}
