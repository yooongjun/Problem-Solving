package BackJoon.implementation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 단어 공부
 */
public class BOJ1157 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().toUpperCase();
        Map<Character, Integer> map = new HashMap<>();
        int max = 1;
        char maxC = ' ';

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!map.containsKey(c)) map.put(c, 1);
            else {
                int n = map.get(c);
                map.put(c, n + 1);
                max = Math.max(max, n + 1);
            }
        }

        for (Character c : map.keySet()) {
            Integer now = map.get(c);
            if (now >= max) {
                if (maxC != ' ') {
                    maxC = '?';
                    break;
                }
                maxC = c;
            }
        }

        System.out.println(maxC);
    }


}
