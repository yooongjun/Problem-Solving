package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 민서의 응급 수술
public class BOJ20955 {

    static int N, M;
    static int parents[];
    static int count;

    // dfs 변수
    static boolean visit[]; // 뉴런 방문 여부
    static List<Integer>[] adjList;

    static int before;
    // dfs 변수


    // 부모 노드(속한 집합)를 찾는 메서드
    private int find(int node) {

        if (parents[node] < 0) {
            return node;
        }

        return parents[node] = find(parents[node]);
    }
    
    // 집합 a와 b를 합치는 메서드
    private boolean union(int a, int b){

        // 각 노드의 집합을 찾습니다.
        int pA = find(a);
        int pB = find(b);

        // 이미 같은 집합인 경우
        if (pA == pB) {
            return false;
        }

        // 다른 경우에는 집합을 합칩니다.
        parents[pA] = pB;
        return true;
    }
    

    private void solution() throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parents = new int[N + 1];
        Arrays.fill(parents, -1);

        // 설명에서 1, 2의 해당하는 부분
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 연결된 두 노드를 합치고, 순환이 발생한 경우 count를 하나 세줍니다.
            if (!union(a, b)) {
                count++;
            }
        }

        // 집합의 수를 저장할 변수
        int groupCnt = 0;

        // 설명에서 3에 해당하는 부분입니다.
        // 집합의 수를 세줍니다.
        for (int i = 1; i <= N; i++) {
            if (parents[i] < 0) {
                groupCnt++;
            }
        }

        // 총 연산 수 계산
        count += (groupCnt - 1);

        System.out.println(count);
    }

    private void solutionA() throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bufferedReader.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        adjList = new ArrayList[N + 1];
        visit = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        // 인접리스트를 생성해주기
        for (int i = 0; i < M; i++) {
            s = bufferedReader.readLine().split(" ");
            int u = Integer.parseInt(s[0]);
            int v = Integer.parseInt(s[1]);
            adjList[u].add(v);
            adjList[v].add(u);
        }

        dfs(0, 1);

        for (int i = 2; i <= N; i++) {
            if (!visit[i]) {
                count++;
                dfs(0, i);
            }
        }

        System.out.println(count);

    }



    public static void main(String[] args) throws Exception {
        new BOJ20955().solution();
    }


    static void dfs(int before, int neuron) {

        visit[neuron] = true;

        for (Integer next : adjList[neuron]) {
            if (next == before) {
                continue;
            }

            if (!visit[next]) {
                dfs(neuron, next);
            }
            // 순환이 발생하는 경우 시냅스 끊기
            else {
                count++;
            }
        }
    }

}
