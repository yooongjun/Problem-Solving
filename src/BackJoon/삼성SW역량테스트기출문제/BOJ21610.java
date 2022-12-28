package BackJoon.삼성SW역량테스트기출문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 마법사 상어와 비바라기
public class BOJ21610 {
    static int A[][];
    static int N, M;
    static int mx[] = {0, -1, -1, -1, 0, 1, 1, 1};
    static int my[] = {-1, -1, 0, 1, 1, 1, 0, -1};

    static boolean check[][];

    static Queue<Node> cloud;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N + 1][N + 1];
        for (int i = 1; i < A.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < A[1].length; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cloud = new LinkedList<>();
        cloud.add(new Node(N, 1));
        cloud.add(new Node(N, 2));
        cloud.add(new Node(N - 1, 1));
        cloud.add(new Node(N - 1, 2));


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            if (i != 0) {
                cloud = makeCloud();    // 구름 생성
            }
            // 구름 이동시키는 함수
            moveCloud(d, s);
            // 비 내리기
            rain();
            // 물 복사 버그
            bug();
        }

        makeCloud();

        int sum = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                sum += A[i][j];
            }
        }
        System.out.println(sum);
    }

    private static void bug() {
        int cnt;
        while (!cloud.isEmpty()) {
            // 버그가 적용될 칸
            Node node = cloud.poll();
            cnt = 0;
            for (int i = 1; i < 8; i = i + 2) {
                int xx = node.x + mx[i];
                int yy = node.y + my[i];

                if (xx > 0 && xx <= N && yy > 0 && yy <= N && A[xx][yy] > 0)
                    cnt++;
            }

            A[node.x][node.y] += cnt;

        }
    }

    private static void rain() {
        Queue<Node> temp = new LinkedList<>(); // 물 복사 버그에서 사용하기 위해 구름 정보 유지
        boolean[][] arr = new boolean[N + 1][N + 1];

        while (!cloud.isEmpty()) {
            Node node = cloud.poll();
            // 물이 증가(구름이 사라진) 칸 저장
            arr[node.x][node.y] = true;
            A[node.x][node.y]++;
            temp.add(node);
        }

        cloud = temp;
        check = arr;
    }

    private static void moveCloud(int d, int s) {
        for ( int i =0; i < s; i++){
            Queue<Node> temp = new LinkedList<>();
            while (!cloud.isEmpty()) {
                Node cur = cloud.poll();
                int xx = cur.x + mx[d - 1];
                int yy = cur.y + my[d - 1];

                if (xx < 1) {
                    xx = N + xx;
                }
                if (xx > N) {
                    xx = xx - N;
                }

                if (yy < 1) {
                    yy = N + yy;
                }
                 if (yy > N) {
                    yy = yy - N;
                }
                cur.x = xx;
                cur.y = yy;
                temp.add(cur);
                }
            cloud = temp;
        }
    }

    private static Queue<Node> makeCloud() {
        Queue<Node> queue = new LinkedList<>();
        for (int i = 1; i < A.length; i++) {

            for (int j = 1; j < A.length; j++) {

                if (A[i][j] >= 2 && !check[i][j]) {
                    A[i][j] -= 2;
                    queue.add(new Node(i, j));

                }
            }
        }
        return queue;
    }

    static class Node{
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
        int x;
        int y;
    }




}
