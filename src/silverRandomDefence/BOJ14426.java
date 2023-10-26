package silverRandomDefence;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * 접두사 찾기
 */
public class BOJ14426 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        HashSet<String> strings = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String nString = br.readLine();
            for (int j = 0; j < nString.length(); j++) {
                strings.add(nString.substring(0, j + 1));
            }
        }

        int cnt = 0;

        for (int i = 0; i < m; i++) {
            if (strings.contains(br.readLine())) {
                cnt++;
            }
        }


        System.out.println(cnt);
    }


}
