package BackJoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 뱀
 */
public class BOJ3190 {

    // 좌, 상, 우, 하
    static int mx[] = {0, -1, 0, 1};
    static int my[] = {-1, 0, 1, 0};

    static int n, k, l;
    static boolean apple[][];
    static char map[][];
    static Queue<Info> queue = new LinkedList<>();


    public static void main(String[] args) throws IOException
    {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bufferedReader.readLine());

        map = new char[n + 1][n + 1];
        apple = new boolean[n + 1][n + 1];

        k = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < k; i++) {
            String[] s = bufferedReader.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);

            apple[x][y] = true;
        }

        l = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < l; i++) {
            String[] s = bufferedReader.readLine().split(" ");
            queue.add(new Info(Integer.parseInt(s[0]), s[1].charAt(0)));
        }

        int result = move();

        System.out.println(result);
    }

    static int move() {
        int cnt = 0;
        Queue<Node> moveQueue = new LinkedList<>();

        // 빈 칸 = 'm'
        for (int i = 1; i <= n; i++) Arrays.fill(map[i], 'm');

        Info directionInfo = queue.poll();
        map[1][1] = 's';

        Node head = new Node(1, 1, 2);
        head.isHead = true;
        Node tail = new Node(1, 1, 2);

        moveQueue.add(head);
        moveQueue.add(tail);

        boolean eatApple = false;

        while (!moveQueue.isEmpty()) {
            Node cur = moveQueue.poll();
            boolean changeDirection = false;
            // 방향 전환하기
            if (cur.isHead && directionInfo!= null && (cnt == directionInfo.cnt))
            {
                cur.direction = changeDirection(directionInfo.direction, cur.direction);
                changeDirection = true;
            }


            int xx = cur.x + mx[cur.direction];
            int yy = cur.y + my[cur.direction];

            // 게임 종료 조건
            if (cur.isHead) {
                cnt++;

                if (xx < 1 || xx > n || yy < 1 || yy > n || (map[xx][yy] != 'm') ) break;

                if (apple[xx][yy])
                {
                    eatApple = true;
                    apple[xx][yy] = false;
                }

                if (changeDirection) {
                    map[cur.x][cur.y] = directionInfo.direction;
                    directionInfo = !queue.isEmpty() ? queue.poll() : null;
                }

                map[xx][yy] = 's';

                cur.x = xx;
                cur.y = yy;
                moveQueue.add(cur);
            }
            else
            {
                if (eatApple) {
                    eatApple = false;
                    moveQueue.add(cur);
                }
                else {
                    // 지나감으로 처리
                    cur.direction = changeDirection(map[cur.x][cur.y], cur.direction);
                    map[cur.x][cur.y] = 'm';

                    cur.x = cur.x + mx[cur.direction];
                    cur.y = cur.y + my[cur.direction];
                    moveQueue.add(cur);
                }
            }
        }

        return cnt;
    }

    static int changeDirection(char c, int direction) {

        if (c == 'L') {
            direction -= 1;
            if (direction < 0) direction = 3;
        } else if (c == 'D') {
            direction += 1;
            if(direction > 3) direction = 0;
        }

        return direction;
    }



    static class Node{
        int x, y, direction;
        boolean isHead = false;
        public Node(int x, int y, int direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }

    }

    // 큐에 넣을 변환 정보
    static class Info{

        int cnt;
        char direction; // L, D

        public Info(int cnt, char direction) {
            this.cnt = cnt;
            this.direction = direction;
        }
    }
    

}
