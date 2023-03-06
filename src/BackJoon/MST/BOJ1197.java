package BackJoon.MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 최소 스패닝 트리
 */
public class BOJ1197 {

    static List<Edge> map[];
    static int v , e;
    static PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> e1.cost - e2.cost);

    static int parent[];

    static void union(int a, int b) {
        parent[find(b)] = find(a);
    }


    static int find(int x){

        while (parent[x] != x) {
            x = parent[x];
        }

        return x;
    }


    static int func(){
    int result = 0;

        while (!pq.isEmpty())
        {
            Edge cur = pq.poll();

            int A = find(cur.A);
            int B = find(cur.B);

            if(A == B) continue;

            union(A,B);
            result += cur.cost;

        }

    return result;

    }



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        parent = new int[v+1];
        map = new ArrayList[v+1];

        for(int i = 1; i <= v; i++){
            parent[i] = i;
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            int a,b,c;
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            pq.add(new Edge(a, b, c));
        }

        // 크루스칼 알고리즘 시행
        int answer = func();

        System.out.println(answer);
    }

    static class Edge{

        int A;
        int B;
        int cost;

        public Edge(int a, int b, int cost) {
            A = a;
            B = b;
            this.cost = cost;
        }
    }
}
