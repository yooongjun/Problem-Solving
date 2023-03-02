package BackJoon.IdxTree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * 달리기
 * 좌표 압축 + 인덱스 트리 사용
 */
public class BOJ2517 {

    static int n;
    static int firstLeaf = 1;
    static int idx[];
    static int data[];
    static Map<Integer, Integer> order;

    public static void edit(int x, int v) {
        int tmp = firstLeaf + x - 1;
        idx[tmp] = v;

        while(tmp > 1) {
            tmp /= 2;
            idx[tmp] = idx[tmp*2] + idx[tmp*2 + 1];
        }

    }

    public static int sum(int x, int l, int r, int find_l, int find_r) {

        if( (l > find_r) || (r < find_l) ) {
            return 0;
        }
        else if( (find_l <= l) && (find_r >= r) ) {
            return idx[x];
        }
        else
        {
            return sum(x * 2, l, (l+r)/2, find_l, find_r) + sum(x * 2 + 1 , (l+r)/2 + 1, r, find_l, find_r);
        }
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tmp[];
        n = Integer.parseInt(br.readLine());
        tmp = new int[n+1];
        data = new int[n+1];
        order = new HashMap<>();


        while(firstLeaf < n) firstLeaf *= 2;

        idx = new int[2*firstLeaf];

        for(int i = 1; i <= n; i++)
        {
            data[i] = Integer.parseInt(br.readLine());
            tmp[i] = data[i];
        }

        // 정렬하여 저장
        Arrays.sort(tmp);

        // 좌표 압축
        for(int i =1; i <= n; i++) {
            order.put(tmp[i], i);
        }

        for(int i =1; i <= n; i++) {
            int t= order.get(data[i]);

            // 나보다 작은 구간의 합
            bw.append(i - sum(1, 1, firstLeaf, 1, t-1) + "\n");
            edit(t, 1);
        }

        bw.flush();
    }

}
