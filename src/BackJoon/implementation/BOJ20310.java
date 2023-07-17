package BackJoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 타노스
 */
public class BOJ20310 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        StringBuilder sb = new StringBuilder();

        int cnt_0 = 0, cnt_1 = 0;

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '0') cnt_0++;
            else cnt_1++;
        }

        cnt_1 /= 2;
        cnt_0 /= 2;

        char[] charArray = s.toCharArray();

        for (int i = 0; i < charArray.length; i++) {

            if (charArray[i] == '1' && cnt_1 > 0) {
                charArray[i] = 'x';
                cnt_1--;
            }
            if(cnt_1 <= 0) break;
        }

        for (int i = charArray.length - 1; i >= 0 ; i--) {

            if (charArray[i] == '0' && cnt_0 > 0) {
                charArray[i] = 'x';
                cnt_0--;
            }

            if(cnt_0 <= 0) break;
        }

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] != 'x') {
                sb.append(charArray[i]);
            }

        }

        System.out.println(sb);

    }


}
