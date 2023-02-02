package SDS.day04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 에라토스테네스의 체
public class BOJ2960 {

    static int n, k;
    static List<Integer> prime = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        findPrime();

        System.out.println(prime.get(k - 1));
    }

    static void findPrime() {
        boolean[] visit = new boolean[n+1];

        for(int i=2; i <= n; i++) {

            if(!visit[i]) {

                prime.add(i);
                for(int j = i+i; j <= n; j+=i)
                {
                    if(!visit[j])
                    {
                        visit[j] = true;
                        prime.add(j);
                    }
                }

            }
        }

    }



}
