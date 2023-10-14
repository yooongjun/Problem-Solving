package silverRandomDefence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 접두사
 */
public class BOJ1141 {



    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Set<String> set = new HashSet<>();

        int n = Integer.parseInt(bufferedReader.readLine());

        while (n-- > 0) {
            set.add(bufferedReader.readLine());
        }

        ArrayList<String> strings = new ArrayList<>();

        strings.addAll(set);

        Collections.sort(strings);

        int count = 0;

        for (int i = 0; i < strings.size(); i++) {
            String s = strings.get(i);
            boolean isUnique = true;

            for (int j = i + 1; j < strings.size(); j++) {
                String nextStr = strings.get(j);

                if (nextStr.charAt(0) == s.charAt(0) && nextStr.length() > s.length() && nextStr.substring(0, s.length()).equals(s)) {
                    isUnique = false;
                    break;
                }
            }

            if(isUnique) count++;
        }

        System.out.println(count);
    }

}
