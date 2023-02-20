package BackJoon.IdxTree;


import java.io.*;
import java.util.StringTokenizer;

/**
 * 수열과 커리 21
 * 구간에 더하고 출력
 */
public class BOJ16975 {

    static long idx[];
    static long lazy[];
    static int data[];
    static int firstLeaf = 1;
    static int n, m;


    public static void propagate(int l, int r, int x){

        if(lazy[x] != 0){
            idx[x] += (r-l+1)*lazy[x];

            if(l != r){
                lazy[2*x] += lazy[x];
                lazy[2*x + 1] += lazy[x];
            }

            lazy[x] = 0;
        }

    }

    public static long find(int x, int l, int r, int v){
        propagate(l, r, x);

        if(v < l || v > r){
            return 0;
        }
        else if(l == r && l == v){
            return idx[x];
        }
        else
        {
            return find(2 * x, l, (l+r)/2 , v) + find( x* 2  + 1, (l+r)/2 +1  ,r ,v);
        }
    }



    public static void edit(int x, int l, int r, int find_l, int find_r, int v){
        propagate(l,r,x);

        if(find_l > r || find_r < l){
            return;
        }
        // 해당 지점이 맞는 경우 propagate를 진행
        else if(find_l <= l && r <= find_r){
            lazy[x] = v;
            propagate(l,r,x);
            return;
        }else {
            edit(2*x, l, (l+r)/2, find_l, find_r, v);
            edit(2*x + 1, (l+r)/2 + 1, r, find_l, find_r, v);
        }

        idx[x] = idx[2*x] + idx[2*x+1];
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        while (firstLeaf < 1000000){
            firstLeaf *= 2;
        }

        idx = new long[2*firstLeaf];
        lazy = new long[2*firstLeaf];

        data = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i =1; i < n+1; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }

        for (int i =1; i < n+1; i++){
            idx[firstLeaf + i -1] = data[i];
        }

        for (int i = firstLeaf - 1; i > 0; i--) {
            idx[i] = idx[2 * i] + idx[2* i + 1];
        }


        m = Integer.parseInt(br.readLine());

        for(int i = 0; i <m ; i++)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            if(a == 1){
                int b,c,d;
                b = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken());
                d = Integer.parseInt(st.nextToken());

                edit(1,1,firstLeaf, b,c,d);
            }
            else if ( a == 2){
                int b = Integer.parseInt(st.nextToken());
                bw.append(find(1, 1,firstLeaf, b) + "\n");
            }

        }
        bw.flush();
    }
}
