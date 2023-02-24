package BackJoon.unionFind;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 교수님은 기다리지 않는다
 * 서로소 집합을 활용
 */
public class BOJ3830 {

    static int parent[];
    static int diff[];
    static int n, m;

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void union(int a, int b, int v) {
        int parentA = find(a);
        int parentB = find(b);

        if(parentB != parentA){
        diff[parentB] = diff[a] - diff[b] + v;
        parent[parentB] = parentA;
        }
    }


    public static int find(int a)  {

        if(parent[a] == a){
            return a;
        }

        find(parent[a]);

    return 0;
    }





    public static void main(String[] args) throws IOException{
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));


        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt( st.nextToken());
            m =  Integer.parseInt(st.nextToken());

            if( n == 0 && m == 0)
                break;

            parent=  new int[n+1];

            for(int i = 1; i  <= n; i++)
                parent[i] = i;

            for(int i = 0 ; i < m ; i++)
            {
                st = new StringTokenizer(br.readLine());

                String s = st.nextToken();

                if(s.equals("!")) {
                    int a, b, c;
                    a = Integer.parseInt(st.nextToken());
                    b = Integer.parseInt(st.nextToken());
                    c = Integer.parseInt(st.nextToken());

                    // b집합에 a를 포함시키는 연산
                    union(b,a,c);
                }
                else if(s.equals("?")) {
                    int a,b;
                    a = Integer.parseInt(st.nextToken());
                    b = Integer.parseInt(st.nextToken());
                    find(a);

                }


            }

        }
        bw.flush();

    }



}
