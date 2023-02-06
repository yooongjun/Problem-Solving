package SDS.day06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// MST - 크루스칼 알고리즘 사용
// 엣지 리스트 + Union-find 
// 비용이 작은 엣지부터 선택하여, 이후 같은 집합이면 선택하지 않는 방식
public class BOJ1922 {

    static int n, m;
    static List<Edge> adjList = new ArrayList<>();
    static int[] parent;

    // MST(Minimum Spanning Tree)
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        parent = new int[n+1];

        // 집합 초기화
        for(int i=1; i <=n; i++)
            parent[i] = i;

        for(int i=0; i <m; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a, b, cost;

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());

            adjList.add(new Edge(a,b,cost));
        }

        // cost 순으로 정렬
        Collections.sort(adjList, ((a, b) -> a.cost - b.cost));

        // 간선 수
        int cnt = n-1;

        long result = 0;

        for(int i=0; i < adjList.size(); i++) {

            Edge cur = adjList.get(i);

            // 같은 집합인 경우 추가하지 않음
            if ( find (cur.left) == find(cur.right) )
                continue;

            // 트리에 노드 추가

            union(cur.left, cur.right);
            result += cur.cost;
            cnt --;

            if(cnt == n-1)
                break;
        }

        System.out.println(result);
    }

    static void union(int a, int b) {
        parent[ find(a) ] = find(b);
    }

    static int find(int x) {
        if(parent[x] == x) return x;
        else
            return parent[x] = find(parent[x]);
    }


    static class Edge{

        int left;
        int right;
        int cost;

        Edge(int left, int right, int cost){
            this.left = left;
            this.right = right;
            this.cost = cost;
        }
    }

}
