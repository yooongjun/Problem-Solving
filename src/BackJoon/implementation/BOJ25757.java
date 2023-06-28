package BackJoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * 임스와 함께하는 미니게임
 */
public class BOJ25757 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bufferedReader.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        char game = s[1].charAt(0);

        Set<String> set = new HashSet<>();

        while (n > 0) {
            set.add(bufferedReader.readLine());
            n--;
        }

        int result = 0;

        switch (game) {
            case 'Y':
                result = set.size();
                break;
            case 'F':
                result = set.size() / 2;
                break;
            case 'O':
                result = set.size() / 3;
                break;
        }

        System.out.println(result);
    }


}
