package BackJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 컵라면
public class BOJ1781 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s;

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Question> questions = new PriorityQueue<>((Q1, Q2) -> Q2.deadLine - Q1.deadLine);

        for (int i = 0; i < N; i++) {
            s = new StringTokenizer(br.readLine());

            questions.add(new Question(Integer.parseInt(s.nextToken()), Integer.parseInt(s.nextToken())));
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        int maxDeadline = questions.peek().deadLine;
        int result = 0;

        for (int i = maxDeadline; i > 0; i--) {

            while (!questions.isEmpty()) {

                if (questions.peek().deadLine >= i) {
                    queue.add(questions.poll().value);
                    continue;
                }

                break;
            }


            if (!queue.isEmpty()) {
                result += queue.poll();
            }
        }

        System.out.println(result);
    }

    static class Question {

        int deadLine;
        int value; // 컵라면 수

        public Question(int deadLine, int value) {
            this.deadLine = deadLine;
            this.value = value;
        }

    }

}
