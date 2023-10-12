package silverRandomDefence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 풍선 공장
 */
public class BOJ15810 {

    static int[] staff;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bufferedReader.readLine().split(" ");

        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        staff = new int[n];

        s = bufferedReader.readLine().split(" ");

        // 스태프 입력
        for (int i = 0; i < n; i++) {
            staff[i] = Integer.parseInt(s[i]);
        }

        // 최단 시간으로 오름차순 정렬
        Arrays.sort(staff);

        // 최단 시간 찾기
        long result = findMinTime();

        System.out.println(result);
    }

    private static long findMinTime() {
        long high = (long)staff[0] * m;
        long low = 0;
        long result = -1;

        while (low <= high) {

            long mid = (low + high) / 2;

            // 현재 시간이 조건 만족하는지 체크
            int count = balloonPerMid(mid);

            if (count >= m) {
                result = mid;
                high = mid - 1;
            }

            if (count < m) {
                low = mid + 1;
            }
        }

        return result;
    }

    static int balloonPerMid(long time) {
        int count = 0;

        for (int i = 0; i < n; i++) {
            count += (time / staff[i]);
        }

        return count;
    }


}
