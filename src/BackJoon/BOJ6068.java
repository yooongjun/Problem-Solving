package BackJoon;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 시간 관리하기
public class BOJ6068 {

    static int N = 0;
    static List<Work> works = new ArrayList<>();

    static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < N; i++) {
            String s[] = bufferedReader.readLine().split(" ");

            int weight = Integer.parseInt(s[0]);
            int limit = Integer.parseInt(s[1]);

            works.add(new Work(limit, weight));
        }

        Collections.sort(works);

        binarySearch(0, 1000000);

        System.out.println(result);
    }

    static void binarySearch(int l, int r) {
        int left = l;
        int right = r;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (!isPossible(mid)) {
                r = mid -1;
            }
            else {
                l = mid + 1;
            }
        }
    }

    static boolean isPossible(int wakeUpTime) {
        int time = wakeUpTime;

        for (int i = 0; i < works.size(); i++) {
            Work work = works.get(i);

            time += work.weight;

            if (time > work.limit) {
                return false;
            }
        }

        result = Math.max(result, wakeUpTime);
        return true;
    }

    static class Work implements Comparable<Work> {


        int limit;
        int weight;

        public Work(int limit, int weight) {
            this.limit = limit;
            this.weight = weight;
        }

        @Override
        public int compareTo(@NotNull Work o) {
            return this.limit - o.limit;
        }
    }

}
