package groupStudy.day02.binarySearch.personal;

import java.io.*;
import java.util.Arrays;

/**
 * 로봇 프로젝트
 */
public class BOJ3649 {

    static final int NANO_PARAM = 10000000;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String input = bufferedReader.readLine();
            if(input == null || input.isEmpty()) break;

            int x = Integer.parseInt(input) * NANO_PARAM;
            int n = Integer.parseInt(bufferedReader.readLine());

            int[] legos = new int[n];

            for (int i = 0; i < n; i++) {
                legos[i] = Integer.parseInt(bufferedReader.readLine());
            }

            Arrays.sort(legos);

            int left = 0;
            int right = n - 1;
            boolean isDanger = true;

            while (left < right) {

                int legoLengthSum = legos[left] + legos[right];

                if (legoLengthSum == x) {
                    isDanger = false;
                    break;
                }

                if (legoLengthSum < x) {
                    left++;
                }

                if (legoLengthSum > x) {
                    right--;
                }
            }

            bufferedWriter.append( isDanger ? "danger\n" : "yes " + (legos[left] + " " + legos[right] +"\n"));
        }

        bufferedWriter.flush();
    }
}
