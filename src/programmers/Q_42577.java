package programmers;

import java.util.Arrays;
import java.util.HashMap;

import static java.lang.System.out;

// 전화번호 목록
public class Q_42577 {
    static class Solution {
        public static boolean solution(String[] phone_book) {
            HashMap<String, Integer> prefix = new HashMap<String, Integer>();
            Arrays.sort(phone_book);

            for (int i = 0; i < phone_book.length; i++) {
                String s = phone_book[i];

                for (int j = 1; j <= s.length(); j++) {
                    String subString = s.substring(0, j);

                    if (j == s.length()) {
                        prefix.put(s, 1);
                    } else {
                        if (prefix.containsKey(subString)) {
                            return false;
                        }
                    }
                }
            }


            return true;
        }
    }
}
