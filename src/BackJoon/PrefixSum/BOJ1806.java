package BackJoon.PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 부분합
public class BOJ1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int S = Integer.parseInt(stringTokenizer.nextToken());
        int minDistance = Integer.MAX_VALUE; // 길이
        int cnt=0;
        int prefixSum = 0;

        stringTokenizer = new StringTokenizer(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        while (stringTokenizer.hasMoreTokens()) {
            int num = Integer.parseInt(stringTokenizer.nextToken());

            if (num >= S) {
                System.out.println(1);
                return;
            }

            queue.add(num);
            prefixSum += num;

            if (prefixSum >= S) {

                // 최소 길이를 구하기 위해 앞 수부터 제거
                while (prefixSum - queue.peek() >= S) {
                    Integer poll = queue.poll();
                    prefixSum -= poll;
                }

                cnt = queue.size();
                minDistance = Math.min(minDistance, cnt);
            }
        }

        minDistance = minDistance == Integer.MAX_VALUE ? 0 : minDistance;

        System.out.println(minDistance);
    }


}
