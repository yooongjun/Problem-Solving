package BackJoon.GraphTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 맥주 마시면서 걸어가기
 */
public class BOJ9205 {

    static int t, n;
    static Info[] map;
    static boolean[] visit;

    static int start_x, start_y;
    static int dest_x, dest_y;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s;

        t = Integer.parseInt(br.readLine());

        for (int test = 0; test < t; test++) {

            n = Integer.parseInt(br.readLine());
            map = new Info[n];
            visit = new boolean[n];

            s = br.readLine().split(" ");
            start_x = Integer.parseInt(s[0]);
            start_y = Integer.parseInt(s[1]);

            for (int i = 0; i < n; i++) {
                int x, y;
                s = br.readLine().split(" ");

                x = Integer.parseInt(s[0]);
                y = Integer.parseInt(s[1]);

                map[i] = new Info(x, y);
            }

            s = br.readLine().split(" ");
            dest_x = Integer.parseInt(s[0]);
            dest_y = Integer.parseInt(s[1]);

            if(BFS())
                System.out.println("happy");
            else
                System.out.println("sad");
        }

    }

    private static boolean BFS() {
        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(start_x, start_y, 20));

        while (!queue.isEmpty()) {
            Info cur = queue.poll();

            if( ( Math.abs(cur.x - dest_x) + Math.abs(cur.y - dest_y) ) <= 50 * cur.bottle) return true;

            // 편의점 탐색
            for (int i = 0; i < n; i++) {

                if (visit[i]) continue;

                int x = map[i].x;
                int y = map[i].y;

                int diff = Math.abs(cur.x - x) + Math.abs(cur.y - y);

                // 해당 지점에 갈 수 있는 경우
                if ( diff <= 50 * cur.bottle ) {
                    visit[i] = true;
                    queue.add(new Info(x, y, 20));
                }

            }

        }

        return false;
    }


    static class Info{

        int x,y;

        // 내가 가진 맥주의 개수
        int bottle;

        public Info(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Info(int x, int y, int bottle) {
            this.x = x;
            this.y = y;
            this.bottle = bottle;
        }
    }
}
