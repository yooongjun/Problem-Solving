package BackJoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2667 {
    static int n;
    static char map[][];
    static int mx[] = {0, -1, 0 ,1};
    static int my[] = {-1, 0, 1 ,0};
    static int groupNum = 0;
    static int answer[] = new int[626];
    static Queue<Info> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = s.charAt(j);
                if(map[i][j] == '1') queue.add(new Info(i, j));
            }
        }

        findGroup();

        Arrays.sort(answer);
        System.out.println(groupNum);
        for (int i = 0; i < answer.length; i++) {

            if (answer[i] == 0) continue;

            System.out.println(answer[i]);
        }
    }

    static void findGroup() {
        boolean visit[][] = new boolean[n][n];
        Queue<Info> groupQueue = new LinkedList<>();

        while (!queue.isEmpty()) {
            Info poll = queue.poll();

            if(visit[poll.x][poll.y]) continue;
            visit[poll.x][poll.y] = true;

            Info info = new Info(poll.x, poll.y);
            info.setGroup(groupNum);
            groupQueue.add(info);

            answer[info.group]++;
            groupNum++;

            while (!groupQueue.isEmpty()){

                Info now = groupQueue.poll();

                for (int i = 0; i < 4; i++) {

                    int xx = now.x + mx[i];
                    int yy = now.y + my[i];

                    if ( xx >= 0 && xx < n && yy >= 0 && yy < n && map[xx][yy]=='1' && !visit[xx][yy] ) {
                            visit[xx][yy] = true;
                            answer[now.group]++;
                            Info next = new Info(xx, yy);
                            next.setGroup(now.group);
                            groupQueue.add(next);
                    }
                }

            }
        }
    }

    static class Info {

        int x, y;
        int group = 0;

        public Info(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void setGroup(int group) {
            this.group = group;
        }
    }

}
