package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문자열 게임 2
 */
public class BOJ20437 {

    static int T;

    static int cnt[];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String s = br.readLine();
            int k = Integer.parseInt(br.readLine());
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            cnt = new int[26];

            for (int j = 0; j < s.length(); j++) cnt[s.charAt(j) - 'a']++;

            for (int i = 0; i < s.length(); i++) {

                char ch = s.charAt(i);

                if(cnt[ch-'a'] < k) continue;

                int count = 0;
                int length = 0;

                for (int j = i; j < s.length(); j++) {

                    length++;

                    if (s.charAt(j) == ch)  count++;

                    if (count == k)
                    {
                        min = Math.min(min, length);
                        max = Math.max(max, length);
                        break;
                    }
                }
            }

            if ( (min == Integer.MAX_VALUE) || (max == Integer.MIN_VALUE ) )
            {
                System.out.println(-1);
            }
            else
            {
                System.out.println(min + " " + max);
            }








        }



    }

}
