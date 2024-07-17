package BackJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 도시 분할 계획
public class BOJ1647 {

    static int N, M;
    static int parents[];
    static PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> e1.cost - e2.cost);
    static int cnt = 0;

    static int total = 0;

    private int find(int child) {

        if (parents[child] == child) {
            return parents[child];
        }

        return parents[child] = find(parents[child]);
    }

    private boolean union(int a, int b) {

        int parentA = find(a);
        int parentB = find(b);

        if (parentA != parentB) {
            if (parentA > parentB) {
                parents[parentB] = parentA;
            } else {
                parents[parentA] = parentB;
            }
            return true;
        }

        return false;
    }


    private void makeMst() {

        while (!pq.isEmpty() && cnt < N) {
            Edge edge = pq.poll();
            int a = edge.a;
            int b = edge.b;

            if (union(a, b)) {
                cnt++;
                total += (cnt < N - 1) ? edge.cost : 0;
            }

        }
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        parents = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            int c = Integer.parseInt(stringTokenizer.nextToken());

            pq.add(new Edge(a, b, c));
        }

        makeMst();

        System.out.println(total);
    }

    public static void main(String[] args) throws Exception {
        new BOJ1647().solution();
    }

    class Edge{

        int a, b, cost;

        public Edge(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }
    }

}
