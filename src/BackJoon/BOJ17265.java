package BackJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 나의 인생에는 수학과 함께
public class BOJ17265 {

    static char map[][];
    static int mx[] = {0, 1};
    static int my[] = {1, 0};
    static int min = 10000, max = -10000;
    static int N;


    static int findValue(char[] calculator) {

        int value = calculator[0] - '0';

        for (int i = 1; i < calculator.length; i += 2) {

            int right = calculator[i + 1] - '0';

            switch (calculator[i]) {
                case '+':
                    value += right;
                    break;
                case '-':
                    value -= right;
                    break;
                case '*':
                    value *= right;
                    break;
            }
        }

        return value;
    }


    static void bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        Node start = new Node(x, y);
        start.addOperator(map[x][y], x + y);
        queue.add(start);


        while (!queue.isEmpty()) {

            Node poll = queue.poll();

            for (int i = 0; i < 2; i++) {
                int xx = poll.x + mx[i];
                int yy = poll.y + my[i];

                if (xx >= 0 && xx < N && yy >= 0 && yy < N) {
                    Node node = new Node(xx, yy);
                    node.copyOperator(poll.calculator);
                    node.addOperator(map[xx][yy], xx + yy);
                    queue.add(node);
                }
            }

            // 도착한 경우
            if(poll.x == N -1 && poll.y == N -1) {
                int result = findValue(poll.calculator);
                min = Math.min(min, result);
                max = Math.max(max, result);
            }
        }
    }


    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = stringTokenizer.nextToken().charAt(0);
            }
        }

        bfs(0, 0);

        System.out.println(max + " " + min);
    }

    public static void main(String[] args) throws Exception {
        new BOJ17265().solution();
    }

}

class Node{
    int x, y;
    char[] calculator = new char[25];

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void addOperator(char op, int idx) {
        calculator[idx] = op;
    }

    void copyOperator(char[] op) {
        this.calculator = op.clone();
    }
}