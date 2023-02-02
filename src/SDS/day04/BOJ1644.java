package SDS.day04;

import java.util.Scanner;

// 소수의 누적합
public class BOJ1644 {
    static long primeSum[];

    static boolean visit[];
    static int cnt = 0;
    static int idx = 1;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        primeSum = new long[n + 1];

        findprimeSum(n);
        tp(n);

        System.out.println(cnt);

    }

    static void findprimeSum(int n){
        boolean visit[] = new boolean[n+1];

        for(int i=2; i <= Math.sqrt(n); i++) {

            if(!visit[i])
            {
                for(int j= i+i; j<= n; j+=i)
                    visit[j] = true;
            }
        }

        for(int i=2; i <= n; i++)
        {
            if(!visit[i])
            {
                primeSum[idx] = primeSum[idx -1] + i;
                idx++;
            }
        }
    }

    static void tp(int n) {
        int i = 0;
        int j = 1;

        while(j <= idx && j > i){
            long sum = primeSum[j] - primeSum[i];

            if(sum == n)
            {
                cnt++;
                i++;
                j++;
            }

            if(sum < n) j++;

            if(sum > n) i++;

        }


    }

}
