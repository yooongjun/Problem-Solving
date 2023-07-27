package groupStudy.day01.implementation.personal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 인구 이동
 */
public class BOJ16234 {

    static int[] mx = {0, -1, 0, 1};
    static int[] my = {-1, 0, 1, 0};
    static int map[][];
    static int L, R;
    static boolean isMoved;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int result = 0;

        int N = Integer.parseInt(s[0]);
        L = Integer.parseInt(s[1]);
        R = Integer.parseInt(s[2]);

        map = new int[N][N];

        for (int i = 0; i < map.length; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        // DFS로 모든 나라에 대해 연합 체크
        while (true) {
            if (!move()) break;
            result++;
        }

        System.out.println(result);
    }

    public static boolean move() {
        boolean visit[][] = new boolean[map.length][map[0].length];
        isMoved = false;

        // 모든 나라에 대해 수행
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (!visit[i][j]) {
                    dfs(i, j, visit);
                }
            }
        }
        return isMoved;
    }

    public static boolean dfs(int i, int j, boolean[][] visit) {
        Stack<Country> stack = new Stack<>();
        List<Country> tmp = new ArrayList<>();
        int groupSum = 0;

        // 처음 방문하는 나라를 stack에 추가
        stack.add(new Country(i, j));
        visit[i][j] = true;

        while (!stack.isEmpty()) {
            Country now = stack.pop();
            tmp.add(now);

            groupSum += map[now.x][now.y];

            for (int m = 0; m < 4; m++) {
                int xx = now.x + mx[m];
                int yy = now.y + my[m];

                if (xx >= 0 && xx < map.length && yy >= 0 && yy < map[0].length && !visit[xx][yy]) {
                    if (check(map[now.x][now.y], map[xx][yy])) {
                        visit[xx][yy] = true;
                        isMoved = true;
                        stack.add(new Country(xx, yy));
                    }
                }
            }
        }

        if(tmp.size() > 0)
            groupSum /= tmp.size();

        for (Country c : tmp) map[c.x][c.y] = groupSum;

        return isMoved;
    }

    // 인구 이동 조건을 확인하는 메서드
    public static boolean check(int n1, int n2){

        if (n1 < n2) {
            int tmp = n1;
            n1 = n2;
            n2 = tmp;
        }

        if( ((n1-n2) >= L) && ((n1-n2) <= R) ) return true;

        return false;
    }


    static class Country{
        int x, y;

        public Country(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
