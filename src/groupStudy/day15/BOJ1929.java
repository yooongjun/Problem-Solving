package groupStudy.day15;

import java.util.Scanner;

/**
 * 소수 구하기
 */
public class BOJ1929 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();
        int n = scanner.nextInt();

        boolean isNotPrime[] = new boolean[1000001];

        isNotPrime[1] = true;

        for (int i = 2; i <= 1000; i++) {
            for (int j = 2; i * j <= 1000000 ; j++)
            {
                isNotPrime[i * j] = true;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = m; i <= n; i++) {
            if (!isNotPrime[i]) {
                stringBuilder.append(i + "\n");
            }
        }

        System.out.println(stringBuilder);
    }


}
