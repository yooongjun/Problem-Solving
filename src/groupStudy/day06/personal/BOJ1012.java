package groupStudy.day06.personal;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ1012 {

   static int mx[] = {0, -1, 0, 1};
    static int my[] = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());

        while (T-- > 0) {
            String s[] = bufferedReader.readLine().split(" ");
            int M = Integer.parseInt(s[0]);
            int N = Integer.parseInt(s[1]);
            int K = Integer.parseInt(s[2]);
            ArrayList<Info> infos = new ArrayList<>();

            int map[][] = new int[M][N];

            for (int i = 0; i < K; i++) {
                int x, y;
                String[] xy = bufferedReader.readLine().split(" ");

                x = Integer.parseInt(xy[0]);
                y = Integer.parseInt(xy[1]);

                map[x][y] = 1;
                infos.add(new Info(x, y));
            }

            bufferedWriter.append(findNum(map, infos) + "\n");
        }

        bufferedWriter.flush();
    }

    private static int findNum(int[][] map, ArrayList<Info> infos) {
        int num = 0;
        Queue<Info> queue = new LinkedList<>();
        boolean visit[][] = new boolean[map.length][map[0].length];

        for (Info info : infos) {

            if (visit[info.x][info.y]) continue;

            queue.add(info);
            visit[info.x][info.y] = true;
            num++;

            while (!queue.isEmpty()) {
                Info cur = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int xx = cur.x + mx[i];
                    int yy = cur.y + my[i];

                    if(xx < 0 || xx >= map.length || yy < 0 || yy >= map[0].length || map[xx][yy] != 1 || visit[xx][yy]) continue;

                    visit[xx][yy] = true;
                    queue.add(new Info(xx, yy));

                }
            }
        }


        return num;
    }

    static class Info {

        int x, y;

        public Info(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
