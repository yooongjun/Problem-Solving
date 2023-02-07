package SDS.day07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 타임머신
// 벨만 포드 알고리즘 사용
public class BOJ11657 {

    // 엣지 리스트
    static List<Edge> list = new ArrayList<>();

    static int n, m;

    static long cost[];

    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");


        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        cost = new long[501];

        // 초기 상태
        for(int i = 2; i < 501; i++)
            cost[i] = INF;

        for(int i = 0; i < m; i++) {
            int a, b, c;
            s = br.readLine().split(" ");
            a = Integer.parseInt(s[0]);
            b = Integer.parseInt(s[1]);
            c = Integer.parseInt(s[2]);

            list.add(new Edge(a,b,c));
        }


        // 번호 순으로 정렬
        Collections.sort(list, (e1, e2) -> e1.a - e2.a);

        int t = 1;

        for(int i = 1; i < n; i++) {
            for(Edge e : list) {

                if(cost[e.a] !=  INF) {

                    cost[e.b] = Math.min(cost[e.b] , cost[e.a] + e.cost);

                }
            }
        }

        boolean hasMinusCycle = false;

        for(int i = 1; i <= 1; i++) {
            for(Edge e : list) {

                if(cost[e.a] !=  INF) {

                    long tmp = cost[e.b];
                    cost[e.b] = Math.min(cost[e.b] , cost[e.a] + e.cost);

                    if( tmp != cost[e.b])
                    {
                        hasMinusCycle = true;
                        break;
                    }
                }

            }
            if(hasMinusCycle)
                break;
        }


        for(int i = 2; i <= n; i++) {
            if(hasMinusCycle)
            {
                System.out.println(-1);
                break;
            }

            System.out.println( ( cost[i] != INF ) ? cost[i] : -1);
        }
    }

    static class Edge{

        int a;
        int b;
        int cost;

        Edge(int a,int b, int cost){
            this.a = a;
            this.b = b;
            this.cost = cost;
        }
    }


}
