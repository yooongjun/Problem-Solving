package BackJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

// 비슷한 단어
public class BOJ1411 {

    static int N;
    static String[] strings;
    static int cnt = 0;
    static HashMap<Character, Character> map;

    private boolean isSimilar(String s1, String s2) {
        map = new HashMap<>();
        boolean isUsed[] = new boolean['z' - 'a' + 1];

        for (int i = 0; i < s1.length(); i++) {
            char a = s1.charAt(i);
            char b = s2.charAt(i);

            if ((map.containsKey(a) && map.get(a) != b) || !map.containsKey(a) && isUsed[b - 'a']) {
                return false;
            }
            isUsed[b - 'a'] = true;
            map.put(a, b);
        }

        return true;
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        strings = new String[N];

        for (int i = 0; i < N; i++) {
            strings[i] = br.readLine();
        }

        for (int i = 0; i < N; i++) {
            String s = strings[i];
            for (int j = i + 1; j < N; j++) {
                cnt += (isSimilar(s, strings[j]) ? 1 : 0);
            }
        }

        System.out.println(cnt);
    }

    public static void main(String[] args) throws Exception {
        new BOJ1411().solution();
    }

}
