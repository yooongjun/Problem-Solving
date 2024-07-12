package BackJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ18430 {

    static int N, M;
    static int map[][];
    static boolean visit[][];
    static int[] mx_left = {1, 0, -1, 0};
    static int[] my_left = {0, -1, 0, 1};
    static int[] mx_right = {0, -1, 0, 1};
    static int[] my_right = {-1, 0, 1, 0};
    static int max = 0;

    private void back(int x, int y, int sum){
        max = Math.max(max, sum);

        for (int i = x; i < N; i++){
            for (int j = y; j < M; j++) {

                if (!visit[i][j]) {

                    // 4개의 부메랑 만들기
                    for(int k = 0; k < 4; k++){
                        int x1 = i + mx_left[k];
                        int y1 = j + my_left[k];
                        int x2 = i + mx_right[k];
                        int y2 = j + my_right[k];

                        if (x1 >= 0 && y1 >= 0 && x1 < N && y1 < M && x2 >= 0 && y2 >= 0 && x2 < N && y2 < M && !visit[x1][y1] && !visit[x2][y2]) {
                            visit[i][j] = true;
                            visit[x1][y1] = true;
                            visit[x2][y2] = true;
                            int tmp = sum + 2 * map[i][j] + map[x1][y1] + map[x2][y2];
                            back(i, j ,tmp);
                            visit[i][j] = false;
                            visit[x1][y1] = false;
                            visit[x2][y2] = false;
                        }
                    }

                }
                y = 0;
            }
        }


    }

    private void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer =  new StringTokenizer(br.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        map = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            stringTokenizer =  new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        back(0, 0, 0);

        System.out.println(max);
    }

    public static void main(String[] args) throws Exception {
        new BOJ18430().solution();
    }
}

