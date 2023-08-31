package groupStudy.day07.personal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 안전 영역
 */
public class BOJ2468 {

    static int map[][];
    static int n;
    static int maxDepth;
    static int result = 0;

    static int mx[] = {0, -1 , 0, 1};
    static int my[] = {-1, 0, 1, 0};


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] s = bufferedReader.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(s[j]);
                maxDepth = Math.max(maxDepth, map[i][j]);
            }
        }

        for (int i = 0; i < maxDepth; i++) {
            bfs(i);
        }

        System.out.println(result);
    }

    public static void bfs(int limit) {
        boolean visit[][] = new boolean[n][n];
        Queue<Node> queue = new LinkedList<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] > limit && !visit[i][j]) {
                    count++;
                    queue.add(new Node(i, j));
                    visit[i][j] = true;

                    while (!queue.isEmpty()) {
                        Node cur = queue.poll();

                        for (int k = 0; k < 4; k++) {
                            int xx = cur.x + mx[k];
                            int yy = cur.y + my[k];

                            if(xx < 0 || xx >= n || yy < 0 || yy >= n || visit[xx][yy]) continue;

                            if(map[xx][yy] <= limit) continue;

                            visit[xx][yy] = true;
                            queue.add(new Node(xx, yy));
                        }
                    }
                }
            }
        }
        result = Math.max(result, count);
    }

    static class Node{
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }






}
