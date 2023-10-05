package groupStudy.day12.group;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 괄호
 */
public class BOJ9012 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine());

        while (t-- > 0) {
            String s = bufferedReader.readLine();
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                // 스택이 비어있으면 하나 쌓기
                if (stack.isEmpty()) {
                    stack.add(c);
                }
                // 같은 방향의 괄호이면 쌓기
                else if (stack.peek() == c) {
                    stack.add(c);
                }
                // 다른 방향의 괄호이면서 현재 괄호가 닫는 괄호인 경우 스택에서 하나 제거
                else if(c == ')'){
                    stack.pop();
                }
            }

            if (stack.isEmpty()) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
    }



}
