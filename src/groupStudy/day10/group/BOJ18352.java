package groupStudy.day10.group;

import java.io.*;
import java.util.*;

/**
 * 특정 거리의 도시 찾기
 */
public class BOJ18352 {
    static int N, M, K, X;
    static List<Integer> adjacentNodes[];

    private static final int INF = 10000000;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = bufferedReader.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        K = Integer.parseInt(s[2]);
        X = Integer.parseInt(s[3]);

        adjacentNodes = new ArrayList[N + 1];

        // 인접리스트 메모리 할당
        for (int i = 1; i <= N; i++) {
            adjacentNodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            adjacentNodes[start].add(end);
        }

        List<Integer> result =  findShortestPath();

        if (result.isEmpty()) {
            System.out.println(-1);
            return;
        }

        for (Integer i : result) {
            bufferedWriter.append(i + "\n");
        }

        bufferedWriter.flush();
    }

    static List<Integer> findShortestPath() {
        boolean visit[] = new boolean[300001];
        Queue<Node> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        queue.add(new Node(X, 0));
        visit[X] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            for (Integer i : adjacentNodes[cur.node]) {

                if(visit[i]) continue;
                visit[i] = true;

                if (cur.distance + 1 < K) {
                    queue.add(new Node(i, cur.distance + 1));
                }
                if (cur.distance + 1 == K) {
                    result.add(i);
                }
            }
        }

        Collections.sort(result);
        return result;
    }

    static class Node{
        int node;
        int distance;

        public Node(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

}
