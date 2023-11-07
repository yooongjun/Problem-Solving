package groupStudy.day14;

import java.util.Scanner;
import java.util.Stack;

public class BOJ10799 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Stack<Character> stack = new Stack<>();

        // 레이저를 하나의 문자로 바꾸기
        String s = input.replace("()", "|");
        int result = 0;

        for (int i = 0; i < s.length(); i++) {

            // 레이저가 나오는 경우 잘린 막대기를 더해줌
            if (s.charAt(i) == '|') {
                result += stack.size();
                continue;
            }

            // 막대기가 끝나는 지점은 잘린 나머지 부분이니까 1 더해주기
            if (s.charAt(i) == ')') {
                stack.pop();
                result += 1;
            }

            // 막대기 시작 지점은 stack에 추가
            else if (s.charAt(i) == '(') {
                stack.add(s.charAt(i));
            }

        }

        System.out.println(result);

    }

}
