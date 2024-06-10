package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 비슷한 단어
public class BOJ2607 {

    static String firstString;
    static int[] isUsed = new int['Z' - 'A' + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        int result = 0;
        firstString = bufferedReader.readLine();

        for (int i = 0; i < firstString.length(); i++) {
            char c = firstString.charAt(i);
            isUsed[c - 'A']++;
        }

        for (int i = 0; i < n - 1; i++) {
            String s = bufferedReader.readLine();

            if (Math.abs(s.length() - firstString.length()) > 1) {
                continue;
            }

            int cnt = 0;
            int[] tmp = isUsed.clone();

            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (tmp[c - 'A'] > 0) {
                    tmp[c-'A']--;
                    cnt++;
                }
            }

            if (s.length() == firstString.length()) {
                if (Math.abs(cnt - firstString.length()) <= 1) {
                    result++;
                }
            } else if (s.length() > firstString.length()) {
                if (cnt == firstString.length()) {
                    result++;
                }
            } else {
                if (cnt == s.length()) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}
