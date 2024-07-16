package BackJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 트리와 쿼리
public class BOJ15681 {

    static List<Integer>[] adjList;
    static int N, R, Q;
    static int sub[];
    static boolean[] visit;

    private int makeTree(int Node) {

        visit[Node] = true;

        for (Integer next : adjList[Node]) {
            if (!visit[next]) {
                sub[Node] += makeTree(next);
            }
        }

        return sub[Node];
    }


    private void solution() throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        R = Integer.parseInt(stringTokenizer.nextToken());
        Q = Integer.parseInt(stringTokenizer.nextToken());

        adjList = new ArrayList[N + 1];
        sub = new int[N + 1];
        visit = new boolean[N + 1];

        Arrays.fill(sub, 1);

        for (int i = 0; i < N - 1; i++) {
            stringTokenizer =  new StringTokenizer(bufferedReader.readLine());

            int U = Integer.parseInt(stringTokenizer.nextToken());
            int V = Integer.parseInt(stringTokenizer.nextToken());

            if (adjList[U] == null) {
                adjList[U] = new ArrayList<>();
            }

            if (adjList[V] == null) {
                adjList[V] = new ArrayList<>();
            }

            adjList[U].add(V);
            adjList[V].add(U);
        }

        makeTree(R);

        for (int i = 0; i < Q; i++) {
            int query = Integer.parseInt(bufferedReader.readLine());
            bufferedWriter.append(sub[query] + "\n");
        }

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }

    public static void main(String[] args) throws Exception {
        new BOJ15681().solution();
    }

}
