package BackJoon;

import java.io.*;
import java.util.*;

// 반음
public class BOJ2034 {

    static char abcdefg[] = {'.' ,'A', '.', 'B', 'C', '.', 'D','.','E','F','.','G'};
    static int moves[];
    static Deque<Character> deque = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bufferedReader.readLine());
        moves = new int[n];


        for (int i = 0; i < abcdefg.length; i++) {
            deque.add(abcdefg[i]);
        }

        for (int i = 0; i < n; i++) {
            moves[i] = Integer.parseInt(bufferedReader.readLine());
        }

        for (int i = 0; i < abcdefg.length; i++) {
            char start = abcdefg[i];

            if (start == '.') {
                continue;
            }

            char end = findLastKey(i);

            if (end != '.') {
                bufferedWriter.append(start + " " + end + "\n");
            }
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    static char findLastKey(int start) {
        resetDeque();

        for (int i = 0; i < start; i++) {
            deque.addLast(deque.pollFirst());
        }

        for (int i = 0; i < moves.length; i++) {
            int move = moves[i];
            int cnt = 0;

            if (move > 0) {
                while (move-- > 0) {
                    deque.addLast(deque.pollFirst());
                }
            }
            else if (move < 0) {
                while (move++ < 0) {
                    deque.addFirst(deque.pollLast());
                }
            }

            if (deque.peek() == '.') {
                return '.';
            }

        }

        return deque.poll();
    }

    static void resetDeque() {
        deque.clear();

        for (int i = 0; i < abcdefg.length; i++) {
            deque.add(abcdefg[i]);
        }
    }


}
