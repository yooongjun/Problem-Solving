package BackJoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

/**
 * 비밀번호 발음하기
 */
public class BOJ4659 {

    static List<Character> gathers = Arrays.asList('a', 'e', 'i', 'o', 'u');

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = bufferedReader.readLine();

            if(input.equals("end")) break;

            boolean result = func(input);

            if (result) {
                System.out.println("<" + input + "> is acceptable.");
            } else {
                System.out.println("<" + input + "> is not acceptable.");
            }
        }
    }

    private static boolean func(String input) {
        boolean hasGather = false;
        boolean state = false;
        int cnt = 0;
        char before = ' ';

        for (int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);

            if (before == cur) {
                if (cur != 'e' && cur != 'o') {
                    return false;
                }
            }

            if (gathers.contains(cur)) {
                hasGather = true;

                if (!state) {
                    cnt = 0;
                }

                cnt++;
                state = true;

            } else {

                if (state) {
                    cnt = 0;
                }

                cnt++;
                state = false;

            }

            before = cur;
            if(cnt >= 3)
                return false;
        }

        return hasGather;
    }
}
