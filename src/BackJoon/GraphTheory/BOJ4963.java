package BackJoon.GraphTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 섬의 개수
public class BOJ4963 {
    static boolean[][] island = new boolean[50][50];

    static int w;
    static int h;

    static int[] mx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] my = {-1, 0, 1, -1, 1, -1, 0, 1 };


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());

            w = Integer.parseInt(tokenizer.nextToken());
            h = Integer.parseInt(tokenizer.nextToken());

            int cnt = 0;

            if (w == 0 && h == 0) {
                return;
            }

            for (int i = 0; i < h; i++) {
                tokenizer = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    if(Integer.parseInt(tokenizer.nextToken()) == 1)
                        island[i][j] = true;
                }
            }


            for (int i = 0; i < island.length; i++) {
                for (int j = 0; j < island[0].length; j++) {
                    if (island[i][j]) {
                        BFS(i, j); // 이어진 부분 check
                        cnt++;
                    }

                }
            }
            System.out.println(cnt);
        }

    }

    private static void BFS(int x, int y ) {
        Node node = new Node(x, y);
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (island[cur.x][cur.y]) {
                island[cur.x][cur.y] = false;

                for (int i = 0; i < 8; i++) {
                    int xx = cur.x + mx[i];
                    int yy = cur.y + my[i];

                    if (0 <= xx && xx < h && 0 <= yy && yy < w && island[xx][yy]) {
                        queue.add(new Node(xx, yy));
                    }
                }
            }
        }
    }


    static class Node {

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int x;

        int y;
    }






}
