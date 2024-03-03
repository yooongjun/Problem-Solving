package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 점프 점프
public class BOJ14248 {

    static int n;
    static int[] stones;

    static int start;

    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bufferedReader.readLine());
        stones = new int[n + 1];

        String[] s = bufferedReader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            stones[i + 1] = Integer.parseInt(s[i]);
        }

        start = Integer.parseInt(bufferedReader.readLine());

        findCount();

        System.out.println(count);
    }

    static void findCount() {
        Queue<Integer> queue = new LinkedList<>();
        boolean visit[] = new boolean[n + 1];

        queue.add(start);
        visit[start] = true;
        count++;

        while (!queue.isEmpty()) {
            Integer currentPosition = queue.poll();
            int dx = stones[currentPosition];
            int left = currentPosition - dx;
            int right = currentPosition + dx;

            if (left > 0 && !visit[left]) {
                queue.add(left);
                visit[left] = true;
                count++;
            }

            if (right <= n && !visit[right]) {
                queue.add(right);
                visit[right] = true;
                count++;
            }
        }
    }

}
