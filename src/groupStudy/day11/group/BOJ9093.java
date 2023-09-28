package groupStudy.day11.group;

import java.io.*;
import java.util.Stack;

// 단어 뒤집기
public class BOJ9093 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(bufferedReader.readLine());

        while (t-- > 0) {
            String[] s = bufferedReader.readLine().split(" ");
            for (int i = 0; i < s.length; i++) {
                String str = s[i];
                for (int j = str.length() - 1; j >= 0; j--) {
                    bufferedWriter.append(str.charAt(j));
                }
                bufferedWriter.append(" ");
            }
            bufferedWriter.append("\n");
        }

        bufferedWriter.flush();
    }

}
