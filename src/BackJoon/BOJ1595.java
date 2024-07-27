package BackJoon;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1595 {

    static int max = 0, maxDistNode = 1;
    static List<Node> adjList[] = new ArrayList[10001];

    static boolean visit[] = new boolean[10001];
    static int dist[] = new int[10001];

    private void dfs(int now, int cost) {

        dist[now] = cost;
        visit[now] = true;

        if (dist[now] > max) {
            max = dist[now];
            maxDistNode = now;
        }

        for (Node next : adjList[now]) {
            if (!visit[next.dest]) {
                dfs(next.dest, cost + next.cost);
            }
        }
    }

    private void reset() {
        max = 0;
        Arrays.fill(dist, 0);
        visit = new boolean[10001];
    }
    private void findAnswer() {
        dfs(1, 0);
        reset();
        dfs(maxDistNode, 0);
    }


    private void solution() throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = "";

        for (int i = 1; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }

        while (bufferedReader.ready()) {
            s = bufferedReader.readLine();

            if (s.isEmpty()) {
                break;
            }

            StringTokenizer stringTokenizer = new StringTokenizer(s);
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            int c = Integer.parseInt(stringTokenizer.nextToken());

            adjList[a].add(new Node(b, c));
            adjList[b].add(new Node(a, c));
        }

        findAnswer();

        System.out.println(max);
    }

    public static void main(String[] args) throws Exception {
        new BOJ1595().solution();
    }


    class Node{
        int dest, cost;

        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }
}
