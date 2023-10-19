package silverRandomDefence;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 소수 & 팰린드롬
 */
public class BOJ1747 {

    static boolean prime[] = new boolean[1100000];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        setPrimes();


        for (int i = n; i < prime.length; i++) {
            if (prime[i] && isPalindrome(String.valueOf(i))) {
                System.out.println(i);
                return;
            }
        }
    }


    private static boolean isPalindrome(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        StringBuilder reverse = stringBuilder.reverse();

        if (s.equals(reverse.toString())) {
            return true;
        }

        return false;
    }

    private static void setPrimes() {
        Arrays.fill(prime, true);

        prime[1] = false;

        for (int i = 2; i < prime.length; i++) {
            if (prime[i]) {
                for (int j = i* 2;  j < prime.length ; j+=i) {
                    prime[j] = false;
                }
            }
        }
    }

}
