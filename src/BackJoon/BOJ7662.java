package BackJoon;

import java.io.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// 이중 우선순위 큐
public class BOJ7662 {

    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(bufferedReader.readLine());

        while (T-- > 0) {
            int k = Integer.parseInt(bufferedReader.readLine());
            operate(k);
        }

        bufferedWriter.flush();
    }

    static void operate(int k) throws IOException {
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Comparator.reverseOrder());
        HashMap<Integer, Integer> dataCounter = new HashMap<>();
        int Q_size = 0;

        for (int i = 0; i < k; i++) {
            String s[] = bufferedReader.readLine().split(" ");
            char op = s[0].charAt(0);
            int val  = Integer.parseInt(s[1]);

            // Insert 연산
            if (op == 'I') {
                minQ.add(val);
                maxQ.add(val);
                Q_size++;

                if (dataCounter.containsKey(val)) {
                    dataCounter.replace(val, dataCounter.get(val) + 1);
                } else {
                    dataCounter.put(val, 1);
                }
            }

            if (op == 'D') {

                if (Q_size == 0) {
                    continue;
                }

                if (val == 1) {
                    Integer max = maxQ.poll();

                    while (dataCounter.get(max) == 0){
                        max = maxQ.poll();
                    }

                    dataCounter.replace(max, dataCounter.get(max) - 1);
                }

                if (val == -1) {
                    Integer min = minQ.poll();

                    while (dataCounter.get(min) == 0){
                        min = minQ.poll();
                    }

                    dataCounter.replace(min, dataCounter.get(min) - 1);
                }

                Q_size--;
            }
        }

        if (Q_size == 0) {
            bufferedWriter.append("EMPTY\n");
        } else {

            Integer min = minQ.poll();
            Integer max = maxQ.poll();

            while (dataCounter.get(min) == 0){
                min = minQ.poll();
            }

            while (dataCounter.get(max) == 0){
                max = maxQ.poll();
            }
            bufferedWriter.append(max + " ");
            bufferedWriter.append(min +"\n");
        }
    }


}
