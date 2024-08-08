package BackJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 그림
public class BOJ1926 {

    static int mx[] = {0, -1, 0, 1};
    static int my[] = {-1, 0, 1, 0};
    static int count = 0;
    static int max = 0;
    static int sum = 0;
    static boolean visit[][];
    static int n, m;

    private void bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        count++;
        sum++;

        queue.add(new Node(x, y));
        visit[x][y] = false;


        while (!queue.isEmpty()) {

            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int xx = node.x + mx[i];
                int yy = node.y + my[i];

                if (xx >= 0 && xx < n && yy >= 0 && yy < m && visit[xx][yy]) {
                    visit[xx][yy] = false;
                    sum++;
                    queue.add(new Node(xx, yy));
                }
            }
        }

        max = Math.max(max, sum);
        sum = 0;
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());

        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                visit[i][j] = (Integer.parseInt(stringTokenizer.nextToken()) == 1 ? true : false);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visit[i][j]) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(count + "\n" + max);


    }

    public static void main(String[] args) throws Exception {
        new BOJ1926().solution();
    }

    class Node{
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
