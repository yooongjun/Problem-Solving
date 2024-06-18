package BackJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ2374 {

    static int n;
    static int max = 0;

    private void solution() throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        long result = 0;
        Stack<Integer> stack = new Stack<>();

        n = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(bufferedReader.readLine());

            max = Math.max(num, max);

            if (stack.isEmpty()) {
                stack.push(num);
            } else {

                if (stack.peek() < num) {
                    result += num - stack.pop();
                    stack.push(num);
                }

                if (stack.peek() > num) {
                    stack.pop();
                    stack.push(num);
                }
            }
        }

        while (!stack.isEmpty()) {
            result += max - stack.pop();
        }

        System.out.println(result);
    }

    public static void main(String[] args) throws Exception {
        new BOJ2374().solution();
    }


}
