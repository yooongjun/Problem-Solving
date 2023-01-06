package BackJoon.GraphTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 치즈
public class BOJ2638 {

    static int dx[] = {0, -1, 0, 1};
    static int dy[] = {-1, 0, 1, 0};
    static boolean map[][];
    static boolean outAir[][];
    static int N, M;
    static Queue<cheese> queue;
    static boolean[][] meltCheese;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new boolean[N][M];
        outAir = new boolean[N][M];
        meltCheese = new boolean[N][M];
        cheese start = null;

        queue = new LinkedList<>();

        // 입력 처리
        for ( int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                 map[i][j] = Integer.parseInt(st.nextToken()) == 1? true: false;
                if (map[i][j] == true) {
                    queue.add(new cheese(i, j));
                }
            }
        }

        setOutAir(0, 0);
        int result = BFS();
        System.out.println(result);

    }

    private static void setOutAir(int x, int y) {
        Queue<air> airQueue = new LinkedList<>();
        airQueue.add(new air(x, y));
        boolean[][] checked = new boolean[N][M];

        while (!airQueue.isEmpty()) {
            air air = airQueue.poll();

            outAir[air.x][air.y] = true;

            for (int i = 0; i < 4; i++) {

                int xx = air.x + dx[i];
                int yy = air.y + dy[i];

                if (xx >= 0 && xx < N && yy >= 0 && yy < M && !checked[xx][yy]) {
                    if(!map[xx][yy] || meltCheese[xx][yy])
                        airQueue.add(new air(xx, yy));

                    checked[xx][yy] = true;
                }
            }
        }
    }

    static int BFS() {
        int minCnt = 1;
        boolean checked[][] = new boolean[N][M];

        while (!queue.isEmpty()) {
            cheese cur = queue.poll();
            int contact = 0;

            if ( cur.cnt > minCnt ) {
                minCnt = cur.cnt;
                air start = null;
                setOutAir(0, 0);
            }

            for (int i = 0; i < 4; i++) {
                int xx = cur.x + dx[i];
                int yy = cur.y + dy[i];

                if (outAir[xx][yy])
                    contact++;

            }

            if (contact >= 2)
                meltCheese[cur.x][cur.y] = true;
            else
            {
                cur.cnt ++;
                queue.add(cur);
            }

        }
        return minCnt;
    }


    static class air{
        int x;
        int y;
        public air(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class cheese{
        int x;
        int y;
        // 시간
        int cnt = 1;
        public cheese(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }



}
