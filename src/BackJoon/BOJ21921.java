package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

// 블로그
public class BOJ21921 {

    static int sum[];
    static int visitCount[];
    static int N, X;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        String s[] = br.readLine().split(" ");

        int period = 0;
        int max = 0;

        N = Integer.parseInt(s[0]);
        X = Integer.parseInt(s[1]);

        visitCount = new int[N + 1];
        sum = new int[N + 1];

        s = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            visitCount[i] = Integer.parseInt(s[i-1]);
            sum[i] = sum[i-1]+ visitCount[i];

            if (i >= X) {
                int visitorPerPeriod = sum[i] - sum[i - X];

                if(visitorPerPeriod > 0)
                    priorityQueue.add(visitorPerPeriod);
            }
        }

        if (priorityQueue.isEmpty()) {
            System.out.println("SAD");
            return;
        }

        max = priorityQueue.poll();
        period = 1;

        while (!priorityQueue.isEmpty()) {
            if (priorityQueue.poll() == max) {
                period++;
            } else {
                break;
            }
        }

        System.out.println(max + "\n" + period);
    }


}
