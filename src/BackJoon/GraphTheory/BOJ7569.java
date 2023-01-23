package BackJoon.GraphTheory;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.SequenceInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 토마토
public class BOJ7569 {

    static int M, N, H;

    static int map[][][];

    static int mx[] = {0, -1, 0, 1, 0, 0};
    static int my[] = {-1, 0, 1, 0, 0, 0};
    static int mz[] = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int tomatoCnt = 0;
        boolean hasYoungTomato = false;
        Queue<NODE> queue = new LinkedList<>();
        map = new int[H][N][M];


        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if (map[i][j][k] == 1) {
                        queue.add(new NODE(j, k, i));
                    }

                    if (map[i][j][k] == 0) {
                        tomatoCnt++;
                    }
                }
            }
        }

        // 모든 토마토가 익어있는 경우
        if (tomatoCnt == 0) {
            System.out.println(0);
            return;
        }

        if (queue.isEmpty()) {
            System.out.println(-1);
            return;
        }

        int result = 0;

        while (true) {

            // 그날 익은 토마토의 수 저장
            int curTomatoNum = queue.size();

            if (tomatoCnt == 0 || queue.isEmpty()) {
                break;
            }
            result ++;

            for (int j = 0; j < curTomatoNum; j++) {

                NODE curTomato = queue.poll();

                for (int i = 0; i < 6; i++) {
                    int xx = curTomato.x + mx[i];
                    int yy = curTomato.y + my[i];
                    int zz = curTomato.z + mz[i];

                    if (xx >= 0 && xx < N && yy >= 0 && yy < M && zz >= 0 && zz < H && map[zz][xx][yy] == 0) {
                        map[zz][xx][yy] = 1;
                        queue.add(new NODE(xx, yy, zz));
                        tomatoCnt--;
                    }
                }

                if (tomatoCnt == 0) {
                    break;
                }
            }
        }

        if (tomatoCnt > 0) {
            result = -1;
        }

        System.out.println(result);
    }





    private static class NODE{

        int x;
        int y;
        int z;

        NODE(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }


    }

}
