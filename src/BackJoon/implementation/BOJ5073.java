package BackJoon.implementation;

import java.io.*;

/**
 * 삼각형과 세 변
 */
public class BOJ5073 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            int a ,b, c, max;
            String s[] = br.readLine().split(" ");

            a = Integer.parseInt(s[0]);
            b = Integer.parseInt(s[1]);
            c = Integer.parseInt(s[2]);
            max = Math.max(a, Math.max(b, c));

            if(a == 0 && b == 0 && c == 0) break;

            if (max >= a + b + c - max) {
                bw.append("Invalid\n");
                continue;
            }

            if(a == b && b == c && c == a) bw.append("Equilateral\n");
            else if(a == b || b == c || c == a) bw.append("Isosceles\n");
            else bw.append("Scalene\n");
        }

        bw.flush();
    }

}
