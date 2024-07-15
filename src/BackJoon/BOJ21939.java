package BackJoon;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

// 문제 추첨 시스템 Version 1
public class BOJ21939 {

    HashMap<Integer, Integer> recommendMap = new HashMap<>();
    PriorityQueue<Question> maxHeap = new PriorityQueue<>();
    PriorityQueue<Question> minHeap = new PriorityQueue<>(Comparator.reverseOrder());
    int N, P;


    private void solve(int num) {

        recommendMap.remove(num);
    }

    private void add(Question q) {
        recommendMap.put(q.p, q.l);
        maxHeap.add(q);
        minHeap.add(q);
    }

    private int recommend(int num) {
        int val = 0;

        // 최댓값 찾기
        if (num == 1) {

            while (!maxHeap.isEmpty()) {
                Question peek = maxHeap.peek();

                if (recommendMap.containsKey(peek.p) && recommendMap.get(peek.p).equals(peek.l)) {
                    val = peek.p;
                    break;
                }

                maxHeap.poll();
            }
        }
        // 최솟값 찾기
        else {

            while (!minHeap.isEmpty()) {

                Question peek = minHeap.peek();

                if (recommendMap.containsKey(peek.p) && recommendMap.get(peek.p).equals(peek.l)) {
                    val = peek.p;
                    break;
                }

                minHeap.poll();
            }
        }

        return val;
    }


    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");

            int num = Integer.parseInt(s[0]);
            int dif = Integer.parseInt(s[1]);

            recommendMap.put(num, dif);
            maxHeap.add(new Question(num, dif));
            minHeap.add(new Question(num, dif));
        }

        P = Integer.parseInt(br.readLine());

        for (int i = 0; i < P; i++) {

            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

            String command = stringTokenizer.nextToken();

            if (command.equals("add")) {
                int a = Integer.parseInt(stringTokenizer.nextToken());
                int b = Integer.parseInt(stringTokenizer.nextToken());
                add(new Question(a, b));
            }

            if (command.equals("recommend")) {
                bw.append(recommend(Integer.parseInt(stringTokenizer.nextToken())) + "\n");
            }

            if (command.equals("solved")) {
                solve(Integer.parseInt(stringTokenizer.nextToken()));
            }
        }


        bw.flush();
        br.close();
        bw.close();
    }

    public static void main(String[] args) throws Exception{
        new BOJ21939().solution();
    }

    class Question implements Comparable<Question>{

        int p, l;

        public Question(int p, int l) {
            this.p = p;
            this.l = l;
        }

        @Override
        public int compareTo(@NotNull Question o) {

            if (this.l == o.l) {
                return o.p - this.p;
            }

            return o.l - this.l;
        }
    }

}
