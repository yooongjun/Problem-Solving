package BackJoon.TwoPointer;

import java.util.Arrays;
import java.util.Scanner;

// 좋다
public class BOJ1253 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        int arr[] = new int[N];

        int pt1 = 0;
        int pt2 = 1;

        int result = 0;

        // 수가 3개 미만인 경우
        if (N < 3) {
            System.out.println(0);
            return;
        }
        
        // 입력
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        // 오름차순 정렬
        Arrays.sort(arr);

        pt1 = 1;
        pt2 = N-1;

        for (int i = 0; i < N; i++) {

            if (i != 0 && i != N-1) {
                pt1 = 0;
                pt2 = N-1;
            }

            if (i == N - 1) {
                pt1 = 0;
                pt2 = N-2;
            }

            while (true) {

                if (pt1 == pt2) {
                    break;
                }

                int sum = arr[pt1] + arr[pt2];

                if (sum == arr[i]) {
                    result++;
                    break;
                }

                if (sum > arr[i]) {
                    if(pt2 - 1 == i)
                        pt2 -= 2;
                    else
                        pt2 -= 1;
                }

                if (sum < arr[i]) {
                    if (pt1 + 1 == i)
                        pt1 += 2;
                    else
                        pt1 += 1;
                }
            }
        }
        System.out.println(result);

    }


}
