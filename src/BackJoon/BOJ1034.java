package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 램프
public class BOJ1034 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s[] = bufferedReader.readLine().split(" ");

        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        int map[][] = new int[N][M];

        // 입력 받기
        for (int i = 0; i < N; i++) {
            String row = bufferedReader.readLine();
            for (int j = 0; j < M; j++) {
                char c = row.charAt(j);
                map[i][j] = c - '0';
            }
        }

        int K = Integer.parseInt(bufferedReader.readLine());

        // 각 행으로 상황을 비교하며 최대값을 반환하는 메서드
        int max = findMax(N, M, map, K);

        System.out.println(max);
    }

    static int findMax(int rowSize, int colSize, int[][] lamp, int possibleCount) {
        int max = 0;

        // 행 기준으로 확인하기
        for (int i = 0; i < rowSize; i++) {
            // 조사할 행 지정
            int[] find = lamp[i].clone();
            int buttonCount = 0;
            int num = 0;

            // 해당 행을 킬 수 있는지 확인
            for (int j = 0; j < colSize; j++) {
                if (find[j] == 0) {
                    buttonCount++;
                }
            }

            // 만약 해당 행을 킬 수 없다면 continue;
            if (buttonCount > possibleCount) {
                continue;
            }

            if (buttonCount < possibleCount && (possibleCount - buttonCount) % 2 != 0) {
                continue;
            }

            num++;

            // 다른 행 조사하기
            for (int j = 0; j < rowSize; j++) {

                boolean key = true;

                if(i == j)
                    continue;

                for (int k = 0; k < colSize; k++) {
                    if (find[k] != lamp[j][k]) {
                        key = false;
                        break;
                    }
                }

                if (key) {
                    num++;
                }

            }
            max = Math.max(num, max);
        }
        return max;
    }


}
