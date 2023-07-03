package BackJoon.implementation;

import java.io.*;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * 영단어 암기는 괴로워
 */
public class BOJ20920 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] split = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        HashMap<String, Integer> map = new HashMap<>();
        PriorityQueue<Word> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            String s = bufferedReader.readLine();

            if(s.length() < m) continue;

            if(map.containsKey(s))
                map.put(s, map.get(s) + 1);
            else
                map.put(s, 1);
        }

        for (String s : map.keySet()) {
            pq.add(new Word(s, map.get(s), s.length()));
        }

        while (!pq.isEmpty()) {
            Word poll = pq.poll();
            bufferedWriter.append(poll.s + "\n");
        }

        bufferedWriter.flush();
    }

    static class Word implements Comparable<Word>{

        String s;
        int cnt;
        int length;

        public Word(String s, int cnt, int length) {
            this.s = s;
            this.cnt = cnt;
            this.length = length;
        }

        @Override
        public int compareTo(Word o) {

            if (this.cnt < o.cnt) {
                return 1;
            } else if (this.cnt == o.cnt) {

                if (this.length < o.length) {
                    return 1;
                }
                else if (this.length == o.length)
                {
                    if (o.s.compareTo(this.s) < 0) {
                        return 1;
                    }
                }
            }
            return -1;
        }
    }

}
