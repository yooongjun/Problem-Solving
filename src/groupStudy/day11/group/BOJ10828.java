package groupStudy.day11.group;

import java.io.*;

/**
 * 스택
 */
public class BOJ10828 {

    static int stack[] = new int[10001];
    static int N;

    static int top = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bufferedReader.readLine());

        while (N-- > 0) {
            String[] s = bufferedReader.readLine().split(" ");

            // 매개변수가 있는 연산
            if (s.length == 2) {
                command(s[0], s[1]);
            }

            // 매개변수가 없는 연산
            else{
                bufferedWriter.append(command(s[0]) + "\n");
            }
        }

        bufferedWriter.flush();
    }

    private static int command(String command) {

        int output = 0;

        switch (command) {
            case "pop":
                output = (top == -1 ? -1 : stack[top--]);
                break;

            case "top":
                output = (top == -1 ? -1 : stack[top]);
                break;

            case "size":
                output = top + 1;
                break;
            case "empty":
                output = (top == -1 ? 1 : 0);
                break;
        }

        return output;
    }

    private static void command(String command, String parameter) {
        stack[++top] = Integer.parseInt(parameter);
    }




}
