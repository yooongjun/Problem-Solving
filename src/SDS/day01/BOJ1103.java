package SDS.day01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 게임
public class BOJ1103 {

    static int[] mx = {0, -1, 0, 1};
    static int[] my = {-1, 0, 1, 0};
    static int n, m;
    static int map[][];
    static int max = 0;
    static boolean visit[][];
    static int dist[][];
    static boolean infinity = false;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        n = Integer.parseInt(strs[0]);
        m = Integer.parseInt(strs[1]);

        map = new int[n+1][m+1];
        visit = new boolean[n+1][m+1];
        dist = new int[n+1][m+1];


        for(int i=1; i < n+1; i++) {
            String s = br.readLine();

            for(int j=0; j < m; j++) {
                map[i][j + 1] = s.charAt(j) == 'H' ? 0 : s.charAt(j) - '0';
            }
        }

        visit[1][1] = true;
        back(1,1, 1);

        if(infinity)
            System.out.println(-1);
        else
            System.out.println(max);

    }

    static void back(int x, int y, int cnt) {

        if(dist[x][y] >= cnt)
            return;

        dist[x][y] = cnt;
        max = Math.max(cnt, max);


        for(int i=0; i < 4; i++) {
            int xx = x + mx[i]*map[x][y];
            int yy = y + my[i]*map[x][y];


            if(xx > 0  && xx < n+1 && yy > 0 && yy < m+1 && map[xx][yy] != -1) {
                // 루프
                if(visit[xx][yy]) {
                    infinity = true;
                    return;
                }

                else if(map[xx][yy] != 0){
                    visit[xx][yy] = true;

                    back(xx, yy, cnt+1);

                    if(infinity) return;
                    visit[xx][yy] = false;
                }
            }
        }
    }


}
