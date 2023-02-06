package SDS.day06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 집합의 표현
// Union-find 구현하는 문제
public class BOJ1717 {

    static int n, m;
    static int parent[];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");

        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        parent = new int[n+1];

        // 초기화
        for(int i=1; i < n+1; i++)
            parent[i] = i;

        for(int i =0 ; i < m; i++) {
            int t,a,b;
            s = br.readLine().split(" ");
            t = Integer.parseInt(s[0]);
            a = Integer.parseInt(s[1]);
            b = Integer.parseInt(s[2]);

            if(t == 0) {
                union(a,b);
            }
            else if (t ==1) {
                if(find(a) == find(b))
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }
    }


    static void union(int a, int b){
        parent[find(b)] = find(a);
    }

    static int find(int x){

        if(parent[x] == x )
            return x;
        else
            return parent[x] = find(parent[x]);

    }
}
