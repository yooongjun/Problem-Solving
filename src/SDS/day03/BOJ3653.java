package SDS.day03;

import javax.xml.transform.sax.SAXSource;
import java.io.*;
import java.util.StringTokenizer;

public class BOJ3653 {

    static int n,m;
    static int idx[];
    static int firstLeaf = 1;

    // 노드의 현재 위치 저장
    static int dt[];

    // 가장 높은 층
    static int top;

    static void edit(int x){

        if(dt[x] == top){
            return;
        }

        int t = firstLeaf + dt[x] - 1;
        idx[t] = 0;

        // 해당 층에서 제거
        while (t > 0){
            t /= 2;
            idx[t] = idx[t * 2] + idx[t * 2 + 1];
        }

        // top에 쌓기
        top++;

        dt[x] = top;

        t = firstLeaf + dt[x] - 1;
        idx[t] = 1;
        t /= 2;

        while (t > 0){
            idx[t] = idx[t * 2] + idx[t * 2 + 1];
            t /= 2;
        }
    }

    // x 위에 있는 영화 수
    static long sum(int x, int l, int r, int search_l, int search_r) {

        // 구간에 겹치는 부분이 하나도 없는 경우
        if( l > search_r || r < search_l)
            return 0;

        // 현재 노드의 구간이 모두 겹치는 경우
        if( l >= search_l && r <= search_r) {
            return idx[x];
        }

        return sum(x*2, l, (l+r)/2 , search_l, search_r) +
                sum(x*2+1, (l+r)/2 + 1, r, search_l, search_r);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t;
        t = Integer.parseInt(st.nextToken());

        for(int i =0; i <t; i++){

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            dt = new int[n+m+1];
            firstLeaf = 1;

            while(firstLeaf < n + m){
                firstLeaf *= 2;
            }

            idx = new int[2 * (firstLeaf) + 1];

            int tmp = 1;
            // 데이터 입력
            for(int j = firstLeaf; j <= firstLeaf + n - 1; j++){
                idx[j] = 1;

                // 영화의 위치를 저장
                dt[tmp++] = firstLeaf + n - j;
            }

            top = dt[1];


            for(int j = firstLeaf -1; j > 0; j--){
                idx[j] = idx[j * 2] + idx[j * 2 + 1];
            }

            st = new StringTokenizer(br.readLine());
            for(int j=0; j < m - 1; j++){
                int a = Integer.parseInt(st.nextToken());
                bw.append(sum(1, 1, firstLeaf, dt[a] + 1, top) + " ");
                edit(a);
            }

            int a = Integer.parseInt(st.nextToken());

            bw.append(String.valueOf(sum(1, 1, firstLeaf, dt[a] + 1, top)));
            bw.append("\n");
        }
        bw.flush();
    }


}
