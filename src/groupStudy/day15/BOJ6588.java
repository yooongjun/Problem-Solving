package groupStudy.day15;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BOJ6588 {

    static List<Integer> primes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean isNotPrime[] = new boolean[1000001];
        isNotPrime[1] = true;

        for (int i = 2; i <= 1000; i++) {
            for (int j = 2; i * j <= 1000000 ; j++)
            {
                isNotPrime[i * j] = true;
            }
        }

        while (true) {
            int n = Integer.parseInt(bufferedReader.readLine());

            if (n == 0) {
                bufferedWriter.flush();
                bufferedWriter.close();
                break;
            }

            for (int i = 2; i <= n / 2; i++) {
                if (!isNotPrime[i] && !isNotPrime[n - i]) {
                    bufferedWriter.append(n + " = " + i + " + " + (n-i)  + "\n");
                    break;
                }
            }

        }

    }



}
