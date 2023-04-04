package BackJoon.Bruteforcing;

import java.io.*;

/**
 * 0 만들기
 */
public class BOJ7490 {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringBuilder sb = new StringBuilder();

    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t - 1 ; i++) {
            n = Integer.parseInt(br.readLine());
            Back(2, 1, "1");
            bw.append("\n");
        }

        n = Integer.parseInt(br.readLine());
        Back(2, 1, "1");

        bw.flush();
    }



    static void Back(int now, int value, String s) throws IOException {

        if (now > n) {

            if (value == 0) {
                bw.append(s + "\n");
            }
            return;
        }


        if (now == 2) {
            Back(now+1, 12, s + " " + now);
        }

        if (s.length() > 2) {

            if (s.charAt(s.length() - 2) == '+') {
                Back(now + 1, value - (now - 1) + Integer.parseInt((now - 1) + "" + now), s + " " + now);
            } else if (s.charAt(s.length() - 2) == '-') {
                Back(now + 1, value + (now - 1) - Integer.parseInt((now - 1) + "" + now), s + " " + now);
            }
        }

        Back(now + 1, value + now, s + "+" + now);

        Back( now + 1, value - now, s + "-" + now);


    }





}
