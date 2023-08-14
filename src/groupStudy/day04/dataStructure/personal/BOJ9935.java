package groupStudy.day04.dataStructure.personal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 문자열 폭발
 */
public class BOJ9935 {

    static String bombStr;
    static String input;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        input = bufferedReader.readLine();
        bombStr = bufferedReader.readLine();

        Stack<String> stack = new Stack<>();
        StringBuilder buffer = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == bombStr.charAt(0) && buffer.length() > 0) {
                stack.add(buffer.toString());
                buffer = new StringBuilder();
            }

            buffer.append(c);

            // 폭탄 문자열인 경우 버퍼 비우기
            if (String.valueOf(buffer.toString()).equals(String.valueOf(bombStr))) {
                buffer = stack.isEmpty()? new StringBuilder() : new StringBuilder(stack.pop());
                continue;
            }

            // 안전한 문자열은 스택을 비우고 바로 출력버퍼에 추가
            if (isSafe(buffer.toString(), bombStr) || i == input.length() - 1) {
                String reverse = clearStack(stack);
                stringBuilder.append(reverse);
                stringBuilder.append(buffer);
                buffer = stack.isEmpty() ? new StringBuilder() : new StringBuilder(stack.pop());
                continue;
            }

        }

        System.out.println(stringBuilder.length() == 0 ? "FRULA" : stringBuilder);
    }

    private static String clearStack(Stack<String> stack) {
        StringBuilder temp = new StringBuilder();
        while (!stack.isEmpty()) {
            StringBuilder tmp = new StringBuilder();
            temp.append(tmp.append(stack.pop()).reverse());
        }

        StringBuilder reverse = temp.reverse();
        return reverse.toString();
    }

    private static boolean isSafe(String buffer, String bombStr) {

        if (buffer.length() <= bombStr.length() && buffer.charAt(buffer.length() - 1) == bombStr.charAt(buffer.length() - 1)) {
            return false;
        }
        return true;
    }

}

