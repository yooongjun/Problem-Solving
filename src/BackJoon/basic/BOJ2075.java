package BackJoon.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * N번째 큰 수
 */
public class BOJ2075 {

    static int n;
    static int map[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Info> pq = new PriorityQueue<>((i1,i2) -> i2.num - i1.num);

        n = Integer.parseInt(br.readLine());

        map = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            String s[] = br.readLine().split(" ");
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(s[j - 1]);
                if (i == n) pq.add(new Info(i, j, map[i][j]));
            }
        }

        for (int i = 0; i < n - 1; i++) {
            Info max = pq.poll();
            if(max.x > 1)
                pq.add(new Info(max.x - 1, max.y, map[max.x - 1][max.y]));
        }

        System.out.println(pq.poll().num);
    }

    static class Info{
        int x, y, num;

        public Info(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }
}
