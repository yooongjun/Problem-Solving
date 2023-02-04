package SDS.day03;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ3653 {

    static int n,m;
    static long idx[] = new long[300000];
    static int firstLeaf = 1;

    static void edit(int index){
        int x = 1;

        }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t;

        // 빈 idx 트리 생성
        while(firstLeaf < 100000){
            firstLeaf *= 2;
        }

        t = Integer.parseInt(st.nextToken());

        for(int i =0; i <t; i++){
            firstLeaf = 1;
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            while(firstLeaf < n){
                firstLeaf *= 2;
            }

            // 초기 데이터 입력 -> 내 앞에 있는 DVD 수
            for(int j = firstLeaf; j <= firstLeaf + n - 1; j++){
                idx[j] = j - firstLeaf;
            }

            for(int j = firstLeaf -1; j > 0; j--){
                idx[j] = idx[j * 2] + idx[j * 2 + 1];
            }

            st = new StringTokenizer(br.readLine());
            for(int j=0; j < m - 1; j++){
                int a = Integer.parseInt(st.nextToken());
                bw.append(idx[firstLeaf + a -1] + " ");
                edit(firstLeaf + a -1);
            }

            int a = Integer.parseInt(st.nextToken());
            bw.append(String.valueOf(idx[firstLeaf + a - 1]));
            bw.append("\n");
        }
        bw.flush();
    }


}
