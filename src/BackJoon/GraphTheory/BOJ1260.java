package BackJoon.GraphTheory;

import java.io.*;
import java.util.*;

/**
 * DFS와 BFS
 */
public class BOJ1260 {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] map;
    static int n, m, v;

    static boolean visit[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());


        map = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a,b;

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            map[a][b] = 1;
            map[b][a] = 1;

        }

        visit = new boolean[n+1];
        DFS(v);
        bw.append("\n");
        BFS();
        bw.flush();
    }

    static void DFS(int now) throws IOException {

        if(visit[now])
            return;

        visit[now] = true;
        bw.append(now + " ");

        for (int i = 1; i <= n; i++) {

            if(map[now][i] != 0)
                DFS(i);
        }

    }

    static void BFS() throws IOException {
        boolean visit[] = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(v);
        visit[v] = true;

        while (!queue.isEmpty()) {
            Integer now = queue.poll();

            bw.append(now + " ");


            for (int i = 1; i <= n; i++) {

                if (map[now][i] != 0 && !visit[i]) {
                    visit[i] = true;
                    queue.add(i);
                }

            }
        }


        bw.append("\n");
    }
}
