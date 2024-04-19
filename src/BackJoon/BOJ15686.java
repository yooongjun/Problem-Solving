package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 치킨 배달
public class BOJ15686 {

    static int N, M;
    static int map[][];
    static int result = 10000;

    static List<Node> chickens = new ArrayList<>();
    static List<Node> homes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bufferedReader.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            s = bufferedReader.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(s[j]);
                if (map[i][j] == 1) {
                    homes.add(new Node(i, j));
                } else if (map[i][j] == 2) {
                    chickens.add(new Node(i, j));
                }
            }
        }

        back(-1, 0);

        System.out.println(result);

    }

    static void back(int deleteNum, int count) {

        if (chickens.size() - count == M) {
            // 치킨 거리 구하기
            int distance = getDistanceForCity();
            result = Math.min(distance, result);
            return;
        }

        // M개 고르지 않은 경우는 삭제
        for (int i = deleteNum + 1; i < chickens.size(); i++) {
            Node delete = chickens.get(i);
            map[delete.x][delete.y] = 0;
            back(i, count + 1);
            map[delete.x][delete.y] = 2;
        }
    }

    static int getDistanceForCity() {

        int chickenDist = 0;
        // 각 도시에서 가까운 치킨 거리를 찾기
        for (int i = 0; i < homes.size(); i++) {
            Node home = homes.get(i);

            int min = 10000;
            for (int j = 0; j < chickens.size(); j++) {
                Node chicken = chickens.get(j);
                if (map[chicken.x][chicken.y] == 2) {
                    int distanceForEachHome = getDistanceForEachHome(home.x, home.y, chicken.x, chicken.y);
                    min = Math.min(min, distanceForEachHome);
                }
            }
            chickenDist += min;
        }

        return chickenDist;
    }

    static int getDistanceForEachHome(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    static class Node{
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
