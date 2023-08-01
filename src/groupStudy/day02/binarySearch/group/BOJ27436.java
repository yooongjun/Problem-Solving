package groupStudy.day02.binarySearch.group;

import java.util.Scanner;

/**
 * 벌집 2
 */
public class BOJ27436 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long N = scanner.nextLong();                // N 입력받기
        long result = 0;                            // 결과값 

        N = N - 1;                                  // 1. 양변에 1 빼기
        N = (N % 3 == 0 ? N / 3 : (N / 3 + 1) );    // 2. 양변 3으로 나누고, 올림하기

        Double rootN = Math.sqrt(N);                // N의 루트를 씌운 값

        long rootNLongValue = rootN.longValue();    // rootN에서 정수 부분

        if (rootNLongValue * (rootNLongValue + 1) >= N) // 만족하는 K를 찾은 것이므로 K = rootNLongValue
        {
            result = rootNLongValue + 1;
        } else {                                        // 반대의 경우는 K = rootNLongValue + 1이 됩니다.
            result = rootNLongValue + 1 + 1;
        }

        System.out.println(result);
    }
}
