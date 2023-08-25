package groupStudy.day06.group;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 점프왕 쩰리
 */
public class BOJ16173 {

    static int N;
    static int map[][];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] s = bufferedReader.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        boolean result = bfs();

        if(result) System.out.println("HaruHaru");

        else System.out.println("Hing");
    }

    private static boolean bfs() {
        Queue<Node> nodes = new LinkedList<>();
        boolean visit[][] = new boolean[N][N];

        nodes.add(new Node(0, 0));

        while (!nodes.isEmpty()) {

            Node curNode = nodes.poll();
            int mx[] = {0, map[curNode.x][curNode.y]};
            int my[] = {map[curNode.x][curNode.y], 0};

            for (int i = 0; i < 2; i++) {
                int xx = curNode.x + mx[i];
                int yy = curNode.y + my[i];

                if(xx < 0 || xx >= N || yy < 0 || yy >=  N || visit[xx][yy]) continue;

                visit[xx][yy] = true;

                if(map[xx][yy] == -1) return true;

                nodes.add(new Node(xx, yy));
            }
        }

        return false;
    }

    private static class Node{
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


}
