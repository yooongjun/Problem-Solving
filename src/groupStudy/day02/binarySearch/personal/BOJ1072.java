package groupStudy.day02.binarySearch.personal;

import java.io.*;

/**
 * 게임
 */
public class BOJ1072 {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] s = bufferedReader.readLine().split(" ");
        long x = Long.parseLong(s[0]);
        long y = Long.parseLong(s[1]);
        long cur = calRate(x, y, 0);
        long result = -1;

        long l = 0;
        long r = 1000000000l;

        while (l <= r) {
            long mid = ((l + r) / 2);

            if (cur != calRate(x, y, mid)) {
                r = mid - 1;
                result = mid;
            } else {
                l = mid + 1;
            }
        }

        System.out.println(result);
    }

    private static long calRate(long x, long y, long mid) {
        return ((y + mid) * 100 / (x + mid));
    }
}
