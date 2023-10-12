package silverRandomDefence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 아기 상어 2
 */
public class BOJ17086 {

    static int map[][];
    static int mx[] = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int my[] = {-1, 0, 1, 1, 1, 0, -1, -1};
    static int n, m;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] s = bufferedReader.readLine().split(" ");

        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            s = bufferedReader.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        findMax();

        System.out.println(result);
    }

    static void findMax() {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    bfs(i,j);
                }
            }
        }
    }

    static void bfs(int x, int y) {
        boolean visit[][] = new boolean[n][m];
        Queue<Node> nodes = new LinkedList<>();

        nodes.add(new Node(x, y, 0));
        visit[x][y] = true;

        while (!nodes.isEmpty()) {
            Node node = nodes.poll();

            for (int i = 0; i < 8; i++) {
                int xx = node.x + mx[i];
                int yy = node.y + my[i];

                if (xx < 0 || xx >= n || yy < 0 || yy >= m || visit[xx][yy]) {
                    continue;
                }

                // 상어가 나오는 경우 탐색 종료
                if (map[xx][yy] == 1) {
                    result = Math.max(node.cost + 1, result);
                    return;
                }

                visit[xx][yy] = true;
                nodes.add(new Node(xx, yy, node.cost + 1));
            }
        }




    }


    static class Node{
        int x,y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

}
