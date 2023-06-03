package BackJoon.implementation;

import java.io.*;
import java.util.*;

/**
 * AC
 */
public class BOJ5430 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        mainLoop :  for (int i = 0; i < t; i++) {
            String func = br.readLine();
            Deque<Integer> deque = new ArrayDeque<>();
            int length = Integer.parseInt(br.readLine());

            boolean isReverse = false;

            String[] split = br.readLine().replace("[", "").replace("]", "").split(",");

            for (int j = 0; j < length; j++) deque.add(Integer.parseInt(split[j]));

            for (int j = 0; j < func.length(); j++) {

                if (func.charAt(j) == 'R') {
                    isReverse = !isReverse;
                    continue;
                }
                // func.charAt(j) == 'D'
                else if(deque.size() > 0){

                    if (isReverse) {
                        deque.removeLast();
                    } else {
                        deque.removeFirst();
                    }
                    continue;
                }

                bw.append("error\n");
                continue mainLoop;
            }

            bw.append("[");
            if (isReverse) {
                while (deque.size() > 1)
                    bw.append(deque.pollLast() + ",");
            } else {
                while (deque.size() > 1)
                    bw.append(deque.poll() + ",");
            }
            if(!deque.isEmpty()) bw.append(String.valueOf(deque.poll()));
                bw.append("]\n");
        }

        bw.flush();

    }

}
