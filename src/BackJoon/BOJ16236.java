package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 아기 상어
public class BOJ16236 {

    static int map[][];
    static int N;

    static Node currentPosition;
    static int size = 2;
    static int biteCnt = 0;
    static int mx[] = {0, -1, 0, 1};
    static int my[] = {-1, 0, 1, 0};
    static int time = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());

        map = new int[N][N];
        Node start = null;

        for (int i = 0; i < N; i++) {
            String[] s = bufferedReader.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(s[j]);
                if (map[i][j] == 9) {
                    start = new Node(i, j, 0);
                    map[i][j] = 0;
                    continue;
                }
            }
        }

        findTime(start);

        System.out.println(time);
    }


    static void findTime(Node start) {
        currentPosition = start;

        while (true) {
            List<Node> nearestFood = findNearestFood(currentPosition.x, currentPosition.y);

            if (nearestFood.isEmpty()) {
                break;
            }

            move(nearestFood);
        }
    }

    static void move(List<Node> bites) {
        Node best = bites.get(0);

        for (int i = 1; i < bites.size(); i++) {
            Node node = bites.get(i);

            if (node.x < best.x) {
                best = node;
            } else if (node.x == best.x) {

                if (node.y < best.y) {
                    best = node;
                }
            }
        }

        // 먹는부분
        biteCnt++;
        if (biteCnt == size) {
            size++;
            biteCnt = 0;
        }
        map[best.x][best.y] = 0;
        time += best.count;
        currentPosition = best;
    }


    static List<Node> findNearestFood(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Node> bites = new ArrayList<>();// 가까운 곳에 있는 후보들
        boolean visit[][] = new boolean[N][N];
        
        // 초기 설정
        visit[x][y] = true;
        queue.add(new Node(x, y, 0));
        int minCnt = 1000;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) 
            {
                int xx = node.x + mx[i];
                int yy = node.y + my[i];

                // 이동할 수 있는 조건
                if (xx >= 0 && xx < N && yy >= 0 && yy < N && node.count + 1 <= minCnt && !visit[xx][yy] && map[xx][yy] <= size)
                {
                    if (map[xx][yy] != 0 && map[xx][yy] < size) {
                        bites.add(new Node(xx, yy, node.count + 1));
                        minCnt = node.count + 1;
                    }
                    visit[xx][yy] = true;
                    queue.add(new Node(xx, yy, node.count + 1));
                }
            }
        }

        return bites;
    }




    static class Node{
        int x, y;
        int count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

}
