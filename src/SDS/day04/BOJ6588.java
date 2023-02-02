package SDS.day04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

// 골드바흐의 추측
public class BOJ6588 {
    static List<Integer> primes = new ArrayList<>();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean visit[];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 에라토스테네스의 체
        findPrime();

        while(true)
        {
            int n = Integer.parseInt(br.readLine());

            if(n == 0)
                break;

            findSum(n);
        }

        bw.flush();
    }

    static void findPrime() {
        visit = new boolean[10000001];

        for(int i=2; i <= 1000; i ++) {

            if(!visit[i]) {
                for(int j= i+i; j <= 1000000; j += i) {
                    visit[j] = true;
                }
            }
        }

        for(int i=3; i<= 1000000; i += 2)
        {
            if(!visit[i])
                primes.add(i);
        }
    }


    static void findSum(int n) throws IOException {

        for(int i = 0; i < primes.size(); i++) {
            if( !visit[n - primes.get(i)] )
            {
                bw.write(String.format("%d = %d + %d\n", n, primes.get(i), n - primes.get(i) ) );
                return;
            }
        }

        bw.write("Goldbach's conjecture is wrong.");
    }


}
