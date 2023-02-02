package SDS.day03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 사탕상자
public class BOJ2243 {

    static int idx[];
    static int firstLeaf = 1;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while(firstLeaf < 1000000)
            firstLeaf *= 2;

        // 인덱스 트리 생성
        idx = new int[2*firstLeaf + 1];

        StringTokenizer st;
        int a,b,c;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());

            if(a == 1)
            {
                b = Integer.parseInt(st.nextToken());
                c = find(b);

                edit(c, -1);
                System.out.println(c);
            }
            else if(a == 2)
            {
                b = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken());

                edit(b, c);
            }
        }

    }

    static int find(int x){
        int s = 1;

        while (s < firstLeaf){
            if(idx[2*s] >= x){
                s *= 2;
            }
            else
            {
                x -= idx[2*s];
                s = 2*s + 1;
            }
        }

        return s - firstLeaf +1;
    }

    // x로 이동하여 수정
    static void edit(int b, int c){
        int x;
        x = firstLeaf + b -1;
        idx[x] += c;

        while (x > 1){
            x /= 2;
            idx[x] += c;
        }
    }


}
