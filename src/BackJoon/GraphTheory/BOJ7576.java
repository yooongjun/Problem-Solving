package BackJoon.GraphTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 토마토
public class BOJ7576 {

    static int mx[] = {0, -1, 0, 1};
    static int my[] = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int x = Integer.parseInt(s.split(" ")[1]);
        int y = Integer.parseInt(s.split(" ")[0]);
        int map[][] = new int[x][y];
        Queue<Node> queue = new LinkedList<>();
        int result = 0;
        int cnt = 0;
        boolean[][] checked = new boolean[x][y];

        for (int i = 0; i < map.length; i++) {
            s = br.readLine();
            String[] tmp = s.split(" ");
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = Integer.parseInt(tmp[j]);
                if (map[i][j] == 1) {
                    queue.add(new Node(i, j));
                    checked[i][j] = true;
                }
                if (map[i][j] == 0) {
                    cnt++;
                }
            }
        }


        while (true) {
            int num = queue.size();

            if(cnt <= 0 || queue.isEmpty())
                break;

            for (; num > 0; num--) {
                Node cur = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int xx = cur.x + mx[i];
                    int yy = cur.y + my[i];

                    if (xx >= 0 && xx < x && yy >= 0 && yy < y && map[xx][yy] == 0 && !checked[xx][yy]) {
                        checked[xx][yy] = true;
                        queue.add(new Node(xx, yy));
                        cnt --;
                    }

                }

                if (cnt <= 0) {
                    break;
                }
            }

            result++;
        }

        if (cnt > 0) {
            System.out.println(-1);
            return;
        }

        System.out.println(result);

    }

    private static class Node{
        int x;
        int y;

        int cnt = 0;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
