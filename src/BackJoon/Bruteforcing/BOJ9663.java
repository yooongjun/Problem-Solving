package BackJoon.Bruteforcing;

import java.util.Scanner;

// N-Queen
public class BOJ9663 {
    
    // 경우의 수
    static int cnt = 0;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int queen[] = new int[N];
            queen[0] = i;
            dfs(1, queen);
        }

        System.out.println(cnt);
   }

    private static void dfs(int depth, int[] arr) {

        if (depth == N) {
            cnt++;
            return;
        }

        for (int i = 0; i < N; i++) {
            boolean locate = true;

            for (int j = 0; j < depth; j++) {
                if (arr[j] == i || (Math.abs(j - depth) == Math.abs(arr[j] - i))) {
                    locate = false;
                    break;
                }
            }

            if (locate) {
                arr[depth] = i;

                dfs(depth + 1, arr);
            }
        }

    }




}


