package BackJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// 병사 배치하기
public class BOJ18353 {

    static int N;
    static int arr[];
    static int len[];

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        len = new int[N];

        String[] s = br.readLine().split(" ");

        // 병사 입력
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        len[0] = 1;

        for (int i = 1; i < N; i++) {
            len[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i]) {
                    len[i] = Math.max(len[j] + 1, len[i]);
                }
            }
        }

        int max = 0;

        for (int i = 0; i < len.length; i++) {
            max = Math.max(max, len[i]);
        }

        System.out.println(N -max);
    }


    public static void main(String[] args) throws Exception {
        new BOJ18353().solution();
    }

}
