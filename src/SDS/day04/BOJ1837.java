package SDS.day04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 암호제작
public class BOJ1837 {

    static String s;
    static int k;
    static int primes[];
    static int idx = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input[] = br.readLine().split(" ");
        int cnt = 0;

        s = input[0];
        k = Integer.parseInt(input[1]);

        findPrime(k);

        for(int i=0; i< idx; i++) {

            int t = 0;

            for(int j = 0; j < s.length(); j++){
                int divNum = (s.charAt(j) - '0') + 10 * t;
                t = divNum % primes[i];
            }

            if(t == 0)
            {
                System.out.printf("BAD %d", primes[i]);
                return;
            }
        }

        System.out.println("GOOD");
    }

    static void findPrime(int k) {
        boolean check[] = new boolean[k + 1];
        primes = new int[k+1];

        for(int i=2; i <= Math.sqrt(k); i++) {
            if(!check[i]) {
                for(int j= i+i; j<= k; j+=i) {
                    check[j] = true;
                }
            }
        }

        for(int i=2; i < k; i++)
        {
            if(!check[i])
                primes[idx++] = i;
        }
    }



}
