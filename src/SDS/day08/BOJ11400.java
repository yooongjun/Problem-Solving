package SDS.day08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 단절점

/**
 * 단절점 찾는 방법
 * 일단 DFS로 각 노드에 방문 순서를 부여한다.
 * 1. 해당 점이 루트 노드인 경우 -> 자식 노드의 집합이 2개 이상인 경우 단절점
 * 2. 루트 노드가 아닌 경우 -> 해당 노드와 인접한 노드들에서 dfs 실행하여 low 값이 현재 조사하는 노드의 order 보다 작은 경우가 발생하면 그 경우는 단절점이 아님.
 * 다만 그렇지 않은 경우가 하나라도 발생하면 해당 노드는 단절점이다.
 *
 */
public class BOJ11400 {

    static int v, e;

    // 인접 리스트 생성
    static List<Integer> adj[] = new ArrayList[10001];

    // 노드의 Order 저장할 배열 생성
    static int orders[] = new int[10001];

    // 노드별 low를 저장
    static int low[] = new int[10001];

    // 탐색 순서
    static int order = 1;

    // DFS
    static boolean visit[];

    // low를 찾는 로직 실행
    static boolean findLow;

    // 현재 조사하는 노드
    static int search = 0;

    // isRoot - 시작 정점인 경우
    static boolean isRoot[] = new boolean[10001];
    static int child[] = new int[10001];

    // 단절점
    static boolean isCutNode[] = new boolean[10001];
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");

        v = Integer.parseInt(s[0]);
        e = Integer.parseInt(s[1]);

        for(int i = 1; i < adj.length; i++)
            adj[i] = new ArrayList<>();

        for(int i = 0; i < e; i++) {
            s = br.readLine().split(" ");
            int a, b;
            a = Integer.parseInt(s[0]);
            b = Integer.parseInt(s[1]);

            // 무향 그래프 생성
            adj[a].add(b);
            adj[b].add(a);
        }

        visit = new boolean[v+1];

        // 연결 그래프가 아닌 경우를 대비해 모든 노드를 시작 노드로 가정
        // orders 구하기
        for(int i = 1; i <= v; i++)
        {
            order = 0;
            if(!visit[i]) {
                dfs(i, true);
            }
        }

        for(int i =1; i <= v; i++) {

            // 시작 노드이면 child 가 2 이상이어야 함.
            if(isRoot[i])
            {

                if( child[i] >= 2)
                {
                    isCutNode[i] = true;
                    result.add(i);
                }
                continue;

            }

            // 기준 노드
            search = i;

            // 시작 정점이 아닌 경우
            // 단절점 판별
            findLow = true;

            for(Integer x : adj[i]) {
                visit = new boolean[10001];
                isCutNode[search] = true;
                dfs(x, false);

                // 단절점인 경우
                if(isCutNode[search]) {
                    result.add(search);
                    break;
                }
            }

        }

        Collections.sort(result);

        System.out.println(result.size());
        for(int i = 0; i <result.size(); i++)
        {
            if(i != result.size() - 1)
                System.out.print(result.get(i)+ " ");
            else
                System.out.print(result.get(i) + "\n");
        }

    }

    /**
     * @param x : 현재 노드
     * @Param isStart: 시작 노드인지 표시
     */
    static void dfs(int x, boolean isStart) {

        if(!findLow)
            orders[x] = order++;

        visit[x] = true;

        // low를 찾는 로직 추가
        if(findLow) {

            if(!isCutNode[search])
                return;

            // 외부 경로가 있는 경우 false
            if( orders[search] > orders[x]) {
                isCutNode[search] = false;
                return;
            }
        }

        for(int next: adj[x]) {

            if(visit[next] || x == search)
                continue;

            // 시작 노드인 경우 child 의 수를 센다.
            if(isStart) {
                isRoot[x] = true;
                child[x]++;
            }

            dfs(next, false);

            if( findLow && !isCutNode[search])
                return;
        }
    }
}
