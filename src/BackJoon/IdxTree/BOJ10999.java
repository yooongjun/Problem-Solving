package BackJoon.IdxTree;

import java.io.*;
import java.util.StringTokenizer;


/**
 * 구간 합 구하기 2
 * lazy propagation을 사용하여 update 시간을 줄이는 방법을 사용함.
 * 시간 복잡도 : O((M+K)logN)
 */
public class BOJ10999 {

    static int n;
    static long idx[];
    // 원본 트리
    static long lazy[];
    static int firstLeaf = 1;

    static long data[];

    static void propagate(int l, int r, int x) {

        if(lazy[x] != 0) {
            // 해당 노드에 걸려있는 lazy를 갱신
            idx[x] += (r-l +1)*lazy[x];

            // 자식노드가 아닌 경우 물려준다.
            if(l != r) {
                lazy[x*2]  += lazy[x];
                lazy[x*2+1] += lazy[x];
            }

            lazy[x] = 0;
        }

    }


    static void edit(int x, int l, int r, int find_l, int find_r ,long d) {

        propagate(l,r,x);

        if(find_l > r || find_r < l) {
            return;
        }

        else if(find_l <= l && find_r >= r) {
            lazy[x] = d;
            propagate(l, r, x);
            return;
        }
        else {
            edit(2*x, l, (l+r)/2, find_l, find_r, d);
            edit(2*x + 1, (l+r)/2 + 1, r, find_l, find_r, d);
        }

        // 수정 사항 적용
        idx[x] = idx[x*2] + idx[x*2+1];

    }


    static long sum(int x, int l, int r, int find_l, int find_r){

        propagate(l,r,x);

        if(find_l > r || find_r < l) {
            return 0;
        }
        else if(find_l <= l && find_r >= r) {
            return idx[x];
        }
        else {
            return sum(2*x, l, (l+r)/2, find_l, find_r)
                    + sum(2*x + 1, (l+r)/2 + 1, r, find_l, find_r);
        }

    }




    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        m += Integer.parseInt(st.nextToken());

        data = new long[n+1];

        while(firstLeaf < n)
            firstLeaf *= 2;

        idx = new long[2 * firstLeaf];
        lazy = new long[2 * firstLeaf];

        for(int i =1 ; i <= n; i++) {
            data[i] = Long.parseLong(br.readLine());
        }

        for(int i = 1; i <=n; i++)
            idx[firstLeaf + i - 1] = data[i];

        // 원본 구간합
        for(int i = firstLeaf-1; i> 0; i--) {
            idx[i] = idx[i*2] + idx[i*2 +1];
        }


        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());

            if( a == 1) {
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                long d = Long.parseLong(st.nextToken());

                // b, c 구간에 d를 더함
                edit(1, 1, firstLeaf , b,c,d);
            }
            else if ( a == 2) {
                int b,c;

                b = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken());

                bw.append(sum(1, 1, firstLeaf, b,c) +  "\n");
            }

        }


        bw.flush();
    }

}
