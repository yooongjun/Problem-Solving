package SDS.day03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2042 {

    static int n,m,k;

    static long[] idx = new long[3000000];
    static long[] dt;
    static int firstLeaf;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        k = Integer.parseInt(s[2]);

        dt = new long[n + 1];

        for(int i=1 ;i <= n; i++) {
            dt[i] = Long.parseLong(br.readLine());
        }


        // 시작 노드 계산

        firstLeaf = 1;
        while( firstLeaf < n ) firstLeaf *= 2;


        // 데이터 입력
        for(int i= 1; i <= n; i++) {
            idx[firstLeaf + i -1] = dt[i];
        }

        // idx 트리 생성
        for(int i = firstLeaf -1; i>= 1; i--)
        {
            idx[i] = idx[i*2] + idx[i * 2 + 1];
        }

        // 수정 , 부분합 수행
        for (int i =0; i < m + k; i++)
        {
            s = br.readLine().split(" ");
            long a =  Long.parseLong(s[0]);
            long b =  Long.parseLong(s[1]);
            long c =  Long.parseLong(s[2]);

            if( a == 1)
                edit((int)b,c);
            else if(a == 2)
                System.out.println( sum(1, 1, firstLeaf, (int)b, (int)c) );


        }
    }


    static void edit(int i, long v) {
        int x = firstLeaf + i - 1;

        idx[x] = v;
        x /= 2;

        while(x >= 1) {
            // 부모로 이동
            idx[x] = idx[x * 2] + idx[x * 2 + 1];
            x /= 2;
        }
    }

    // top - down
    static long sum(int x, int l, int r, int search_l, int search_r) {

        // 구간에 겹치는 부분이 하나도 없는 경우
        if( l > search_r || r < search_l)
            return 0;

        // 현재 노드의 구간이 모두 겹치는 경우
        if( l >= search_l && r <= search_r)
            return idx[x];

        return sum(x*2, l, (l+r)/2 , search_l, search_r) +
                sum(x*2+1, (l+r)/2 + 1, r, search_l, search_r);
    }





}
