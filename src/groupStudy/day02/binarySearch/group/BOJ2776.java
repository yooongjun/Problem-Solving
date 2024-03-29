package groupStudy.day02.binarySearch.group;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 암기왕
 */
public class BOJ2776 {

    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(bufferedReader.readLine());

        while (T-- > 0) {
            int arr_1[], arr_2[];

            // input
            int N = Integer.parseInt(bufferedReader.readLine());
            String[] s = bufferedReader.readLine().split(" ");

            // 수첩 1 초기화 및 입력 값 저장
            arr_1 = new int[N];
            for (int i = 0; i < N; i++) {
                arr_1[i] = Integer.parseInt(s[i]);
            }

            // input
            int M = Integer.parseInt(bufferedReader.readLine());
            s = bufferedReader.readLine().split(" ");

            // 수첩 2 초기화 및 입력 값 저장
            arr_2 = new int[M];
            for (int i = 0; i < M; i++) {
                arr_2[i] = Integer.parseInt(s[i]);
            }

            // 이분 탐색을 위해 배열을 정렬해줍니다.
            Arrays.sort(arr_1);

            for (int i = 0; i < M; i++) {
                // bufferedWriter.append()는 결과를 출력에 담는 함수입니다.
                // arr_2의 각 원소를 기준으로 arr_1을 이분탐색했습니다.
                bufferedWriter.append(binarySearch(arr_1, arr_2[i]) + "\n");
            }

        }
        // 출력
        bufferedWriter.flush();

        // 종료
        bufferedReader.close();
        bufferedWriter.close();
    }

    // int[] target : 탐색할 배열, find : 찾을 수
    static int binarySearch(int[] target, int find) {

        // left , right
        int l = 0;
        int r = target.length - 1;

        while (l <= r) {
            // 중간 값을 비교
            int mid = (l+r)/2;

            // 같은 값을 찾은 경우 1을 리턴
            if (find == target[mid]) {
                return 1;
            }

            // 중간 값보다 찾는 수가 작은 경우
            if (find < target[mid]) {
                r = mid - 1;
            }
            else // if ( find > target[mid] ) 중간 값보다 찾는 수가 큰 경우
            {
                l = mid + 1;
            }
        }

        // 찾지 못한 경우
        return 0;
    }

}
