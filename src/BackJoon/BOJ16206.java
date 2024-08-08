package BackJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 롤케이크
public class BOJ16206 {

    static int n, m;
    static int A[];
    static int answer = 0;

    static int findSliceCnt(Integer cake) {

        if (cake % 10 == 0) {
            return cake / 10 - 1;
        }

        return cake / 10;
    }

    private void solution() throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Queue<Integer> queue = new LinkedList<>();

        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(stringTokenizer.nextToken());
            if (a <= 10) {
                answer += (a == 10 ? 1 : 0);
                continue;
            }

            if (a % 10 == 0) {
                minHeap.add(a);
            }
            else
                queue.add(a);
        }

        Queue<Integer> tmp = minHeap.isEmpty() ? queue : minHeap;

        while (!tmp.isEmpty() && m > 0) {
            Integer cake = tmp.poll();

            int needCntOfSlice = findSliceCnt(cake);

            if (cake % 10 == 0) {
                answer += (m >= needCntOfSlice ? (needCntOfSlice + 1) : m);
            } else {
                answer += (m >= needCntOfSlice ? (needCntOfSlice) : m);
            }

            m -= needCntOfSlice;
            tmp = minHeap.isEmpty() ? queue : minHeap;
        }

        System.out.println(answer);



    }

    public static void main(String[] args) throws Exception {
        new BOJ16206().solution();
    }

}
