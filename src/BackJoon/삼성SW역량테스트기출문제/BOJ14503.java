package BackJoon.삼성SW역량테스트기출문제;

import java.util.*;
import java.io.*;

// 로봇청소기
public class BOJ14503 {

    static int N, M;
    static int map[][];
    static boolean checked[][];

    static int cnt = 0;

    static int[][] left = {{0, -1, 3}, {-1, 0, 0}, {0, 1, 1}, {1, 0, 2}};

    public static void main(String[] args) throws IOException{

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        checked = new boolean[N][M];

        st = new StringTokenizer(bufferedReader.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N ; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        doClean(r, c, d);
        System.out.println(cnt);
    }

    static void doClean(int r, int c, int d){

        Queue<node> queue = new LinkedList<>();
        boolean flag = false;
        int tmp;
        int direction = d;

        node start = new node(r, c);
        queue.add(start);

        while (!queue.isEmpty()) {
            node cur = queue.poll();
            flag = false;
            tmp = direction;

            if(!checked[cur.x][cur.y]) {
                checked[cur.x][cur.y] = true;
                cnt++;
            }

            for (int i = 0; i < 4; i++) {
                int dx = cur.x + left[direction][0];
                int dy = cur.y + left[direction][1];

                direction = left[direction][2];


                if ( dx < N && dy < M && !checked[dx][dy] && map[dx][dy] == 0 ) {
                    queue.add(new node(dx, dy));
                    flag = true;
                    break;
                }
            }

            // 후진
            if (!flag) {
                direction = tmp;
                node node = goBack(cur.x, cur.y, direction);

                if (node != null)
                    queue.add(node);
            }

        }


    }

    static node goBack(int x, int y, int d){
        int dx =0, dy = 0;

        switch (d) {
            case 0:
                dx = 1;
                dy = 0;
                break;
            case 1:
                dx = 0;
                dy = -1;
                break;
            case 2:
                dx = -1;
                dy = 0;
                break;
            case 3:
                dx = 0;
                dy = 1;
                break;
        }

        int X, Y;
        X = dx + x;
        Y = dy + y;

        if (X > 0 && X < N -1 && Y > 0 && Y < M -1 && map[X][Y] != 1) {
            return new node(X, Y);
        }

        return null;
    }




    static class node{
        int x;
        int y;

        public node(int x, int y) {
            this.x = x;
            this.y = y;
        }


    }



}
