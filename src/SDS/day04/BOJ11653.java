package SDS.day04;

import java.util.Scanner;

// 소인수분해
public class BOJ11653 {

    static int[] primes;
    static int n;
    static int idx = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        findPrime();

        int t = 0;

        while(n > 1) {

            if(n % primes[t] == 0)
            {
                System.out.println(primes[t]);
                n = n / primes[t] + n % primes[t];
            }
            else
                t++;
        }



    }

    static void findPrime() {

        boolean check[] = new boolean[n+1];
        primes = new int[n + 1];

        for(int i = 2; i <= Math.sqrt(n); i++) {

            if( !check[i] )
            {
                for(int j = i+i; j <= n; j+= i) {
                    check[j] = true;
                }

            }
        }

        for(int i=2; i <=n; i++) {

            if(!check[i])
                primes[idx++] = i;
        }





    }

}
