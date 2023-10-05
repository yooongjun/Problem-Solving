package groupStudy.day12.group;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Stack;

/**
 * 스택 수열
 */
public class BOJ1874{
    static Stack<Integer> stack = new Stack<>();
    static StringBuilder stringBuilder = new StringBuilder();

    private static void popAndPrint() {
        stack.pop();
        stringBuilder.append("-\n");
    }

    private static void pushAndPrint(int n) {
        stack.push(n);
        stringBuilder.append("+\n");
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        // 수열 스택에 저장할 차례인 숫자
        int currentNum = 1;

        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();

            if (currentNum <= num) {

                while (currentNum <= num) {
                    pushAndPrint(currentNum++);
                }

                popAndPrint();
            }
            else {

                if (stack.isEmpty()) {
                    System.out.println("NO");
                    return;
                }

                Integer top = stack.peek();

                if (top < num) {
                    System.out.println("NO");
                    return;
                }

                while (!stack.isEmpty() && stack.peek() >= num) {
                    popAndPrint();
                }
            }
        }

        System.out.println(stringBuilder);
    }
}
