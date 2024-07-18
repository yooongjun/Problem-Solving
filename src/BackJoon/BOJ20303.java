package BackJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 할로윈의 양아치
public class BOJ20303 {

    static int N, M, K;
    static ArrayList<Integer>[] adjList;
    static int[] candies;
    static boolean[] visit;
    static List<Group> groups = new ArrayList<>();
    static int cnt = 0, total = 0;
    static int max = 0;
    static int dp[];

    private void findMax() {


        for (Group g : groups) {
            for (int i = K - 1 ; i > 0; i--) {
                if (i - g.num >= 0) {
                    dp[i] = Math.max(dp[i], dp[i - g.num] + g.sum);
                }
            }
        }


        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }


    }

    private void dfs(int idx) {

        visit[idx] = true;
        total += candies[idx];
        cnt++;

        for (Integer next : adjList[idx]) {
            if (!visit[next]) {
                dfs(next);
            }
        }
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        candies = new int[N + 1];
        visit = new boolean[N + 1];
        adjList = new ArrayList[N + 1];
        dp = new int[K];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            candies[i] = Integer.parseInt(st.nextToken());
            adjList[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjList[a].add(b);
            adjList[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            if (!visit[i]) {
                cnt = 0;
                total = 0;
                dfs(i);
                groups.add(new Group(cnt, total));
            }
        }

        findMax();

        System.out.println(max);
    }

    public static void main(String[] args) throws Exception {
        new BOJ20303().solution();
    }


    class Group{

        int num, sum;

        public Group(int num, int sum) {
            this.num = num;
            this.sum = sum;
        }
    }
}
