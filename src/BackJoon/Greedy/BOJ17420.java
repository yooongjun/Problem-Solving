package BackJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 깊콘이 넘쳐흘러
public class BOJ17420 {

    public static void main(String[] args) throws IOException {
        // 아이템 사용 일정이 짧은 순으로 정렬
        PriorityQueue<Item> queue = new PriorityQueue<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1, st2;
        int N = Integer.parseInt(br.readLine());


        st1 = new StringTokenizer(br.readLine());
        st2 = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            queue.add(new Item(Integer.parseInt(st1.nextToken()), Integer.parseInt(st2.nextToken())));
        }

        long result = 0;
        int curMaxLimit = -1;
        boolean checkFirstLoop = true;

        // 같은 plan일정 중 가장 크게 변경된 limit을 다음 plan 일정의 CurMaxLimit으로 반영
        int maxSamePlan = 0;
        boolean isSamePlan = true;

        while (!queue.isEmpty()) {

            Item item = queue.poll();

            // 계획보다 기한이 짧은 경우 기한을 연장
            if (item.plan - item.limit > 0 ) {
                int temp = item.plan - item.limit;
                int extensionCnt = temp / 30 +  ((temp % 30) == 0 ? 0 : 1 );
                result += extensionCnt;
                item.limit += 30 * extensionCnt;
            }

            if (checkFirstLoop) {
                curMaxLimit = item.limit;
                checkFirstLoop = false;
            }

            if (!isSamePlan && item.limit == curMaxLimit) {
                result += 1;
                item.limit += 30;
            }

            if (item.limit < curMaxLimit)
            {
                    int temp = curMaxLimit - item.limit;
                    int extensionCnt = temp / 30 + ((temp % 30) == 0 ? 0 : 1);
                    result += extensionCnt;
                    item.limit += 30 * extensionCnt;
            }

            maxSamePlan = Math.max(item.limit, maxSamePlan);
            isSamePlan = true;

            if ( !queue.isEmpty() && ( queue.peek().plan != item.plan )) {
                curMaxLimit = maxSamePlan;
                maxSamePlan = 0;
                isSamePlan = false;
            }


        }


        System.out.println(result);
    }


    static class Item implements Comparable<Item>{

        int limit;

        int plan;

        public Item(int limit, int plan) {
            this.limit = limit;
            this.plan = plan;
        }

        @Override
        public int compareTo(Item o) {
            if (this.plan == o.plan) {
                return this.limit - o.limit;
            }

            return this.plan - o.plan;
        }
    }

}
