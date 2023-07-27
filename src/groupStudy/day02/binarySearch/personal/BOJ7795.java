package groupStudy.day02.binarySearch.personal;

import java.io.*;
import java.util.Arrays;

/**
 * 먹을 것인가 먹힐 것인가
 */
public class BOJ7795 {

    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(bufferedReader.readLine());

        while (T-- > 0) {
            String s[] = bufferedReader.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);

            s = bufferedReader.readLine().split(" ");

            int A[] = new int[n];
            int B[] = new int[m];

            // A입력
            for (int i = 0; i < n; i++) {
                A[i] = Integer.parseInt(s[i]);
            }

            s = bufferedReader.readLine().split(" ");

            // B입력
            for (int i = 0; i < m; i++) {
                B[i] = Integer.parseInt(s[i]);
            }

            // A와 B를 각각 오름차순 정렬
            Arrays.sort(A);
            Arrays.sort(B);

            int result =  binarySearch(A, B);

            bufferedWriter.append(result + "\n");
        }

        bufferedWriter.flush();
    }

    static int binarySearch(int[] source, int[] target) {
        int result = 0;

        for (int i = 0; i < source.length; i++) {
            int l = 0;
            int r = target.length -1;
            int find = source[i];
            int mid = (l + r) / 2;

            while (l <= r) {
                mid = (l + r) / 2;

                if (find <= target[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }

            result += l;
        }

        return result;
    }

}
