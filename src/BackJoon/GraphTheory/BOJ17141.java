package BackJoon.GraphTheory;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 연구소2
public class BOJ17141 {


    static int map[][];
    static int N;
    static int M;

    static int num; // 채워지는 칸의 수
    static int mx[] = {0, -1, 0, 1};
    static int my[] = {-1, 0, 1, 0};

    static int result = Integer.MAX_VALUE;
    static ArrayList<NODE> virusPlace;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = N*N - M;

        map = new int[N][N];

        virusPlace = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                // 놓을 수 있는 자리
                if (map[i][j] == 2) {
                    virusPlace.add(new NODE(i, j, 0));
                }
                if (map[i][j] == 1) {
                    num --;
                }
            }
        }

        for (int i = 0; i < virusPlace.size() - M + 1 ; i++) {
            int arr[] = new int[M];
            arr[0] = i;
            selectNode(i, 0, arr);
        }

        if (result != Integer.MAX_VALUE) {
            System.out.println(result);
            return;
        }

        System.out.println(-1);
    }

    private static void selectNode(int cur, int depth, int[] arr) {

        if (depth == M - 1) {
            NODE[] virus = new NODE[M];

            for (int i = 0; i < arr.length; i++) {
                virus[i] = virusPlace.get(arr[i]);
            }

            result = Math.min(result, BFS(virus));
            return;
        }

        int tmp[] = arr.clone();

        for (int i = cur + 1; i <= virusPlace.size() - (M - depth) + 1; i++) {
            tmp[depth + 1] = i;
            selectNode(i, depth + 1, tmp);
        }
    }

    static int BFS(NODE virus[]) {
        Queue<NODE> queue = new LinkedList<>();
        boolean check[][] = new boolean[N][N];
        int tmp = num;
        int result = 0;

        for (int i = 0; i < virus.length; i++) {
            queue.add(virus[i]);
            check[virus[i].x][virus[i].y] = true;
        }

        while (!queue.isEmpty()) {
            NODE cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int xx = cur.x + mx[i];
                int yy = cur.y + my[i];

                if (xx >= 0 && xx < N && yy >= 0 && yy < N && map[xx][yy] != 1 && !check[xx][yy]) {
                    check[xx][yy] = true;
                    queue.add(new NODE(xx, yy, cur.cnt +1));
                    tmp --;
                    result = Math.max(cur.cnt + 1, result);
                }

                if (tmp == 0) {
                    return result;
                }
            }
        }

        return Integer.MAX_VALUE;
    }



    private static class NODE{

        int x;
        int y;

        int cnt = 0;

        NODE(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

    }


}

