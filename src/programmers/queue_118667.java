package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 두 큐 합 같게 만들기
public class queue_118667 {

    long sumA, sumB;
    long total;
    long target;

    public int solution(int[] queue1, int[] queue2) {
        int answer = -2;

        Queue<Integer> queueA = new LinkedList<>();
        Queue<Integer> queueB = new LinkedList<>();


        for (int i = 0; i < queue1.length; i++) {
            queueA.add(queue1[i]);
            queueB.add(queue2[i]);
            sumA += queue1[i];
            sumB += queue2[i];
        }

        total = sumA + sumB;

        // 홀수일때 예외처리
        if(total % 2 != 0)
            return -1;

        target = total / 2;

        for (int i = 0; i < queue1.length * 3; i++){

            if (sumA == total) {
                return i;
            }

            if (sumA > total) {
                int tmp = queueA.poll();
                sumA -= tmp;
                queueB.add(tmp);
            }
            else {
                int tmp = queueB.poll();
                sumA += tmp;
                queueA.add(tmp);
            }
        }

        return -1;
    }
}
