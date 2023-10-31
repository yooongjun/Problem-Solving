package groupStudy.day13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class BOJ10845 {

    static Deque<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        int n = Integer.parseInt(bufferedReader.readLine());

        while (n-- > 0) {
            String[] s = bufferedReader.readLine().split(" ");

            if (s.length == 2) {
                queue.add(Integer.parseInt(s[1]));
                continue;
            }

            switch (s[0]) {
                case "pop":
                    stringBuilder.append( (queue.isEmpty() ? -1 : queue.poll()) + "\n");
                    break;

                case "size":
                    stringBuilder.append(queue.size() + "\n");
                    break;
                case "empty":
                    stringBuilder.append((queue.isEmpty() ? 1 : 0) + "\n");
                    break;
                case "front":
                    stringBuilder.append((queue.isEmpty() ? -1 : queue.peek()) + "\n");
                    break;
                case "back":
                    stringBuilder.append((queue.isEmpty() ? -1 : queue.peekLast()) + "\n");
                    break;
            }
        }
        System.out.println(stringBuilder);
    }

}
