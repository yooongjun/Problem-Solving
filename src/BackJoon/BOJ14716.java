package BackJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 현수막
public class BOJ14716 {

    static int mx[] = {0, -1, -1, -1, 0, 1, 1, 1};
    static int my[] = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int M, N;
    static boolean[][] map;
    static int count = 0;


    private void bfs(int x, int y) {
        class Node{
            int x, y;
            public Node(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(x, y));
        map[x][y] = true;

        while (!queue.isEmpty()) {

            Node node = queue.poll();

            for (int i = 0; i < 8; i++) {
                int xx = node.x + mx[i];
                int yy = node.y + my[i];

                if (xx >= 0 && xx < M && yy >= 0 && yy < N && map[xx][yy]) {
                    map[xx][yy] = false;
                    queue.add(new Node(xx, yy));
                }
            }
        }



    }


    private void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken().equals("1");
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j]) {
                    bfs(i, j);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    public static void main(String[] args) throws Exception {
        new BOJ14716().solution();
    }

}
