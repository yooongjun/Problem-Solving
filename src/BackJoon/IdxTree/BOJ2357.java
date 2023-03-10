package BackJoon.IdxTree;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 최솟값과 최댓값
 */
public class BOJ2357 {

    static int firstLeaf = 1;
    static int min[];
    static int max[];
    static int n,m;

    static int data[];

    public static int findMin(int x, int l, int r, int find_l, int find_r){

        if(l > find_r || r < find_l)
            return 1500000000;

        else if(find_l <= l && r <= find_r)
            return min[x];

        else
        {
            return Math.min(findMin(x * 2, l, (l + r) / 2, find_l, find_r), findMin(x * 2 + 1, (l + r) / 2 + 1, r, find_l, find_r));

        }
    }

    public static int findMax(int x, int l, int r, int find_l, int find_r){

        if(l > find_r || r < find_l)
            return 0;

        else if(find_l <= l && r <= find_r)
            return max[x];

        else
        {
            return Math.max(findMax(x * 2, l, (l + r) / 2, find_l, find_r), findMax(x * 2 + 1, (l + r) / 2 + 1, r, find_l, find_r));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        data = new int[n + 1];

        while(firstLeaf < n) firstLeaf *= 2;

        min = new int[firstLeaf * 2];
        max = new int[firstLeaf * 2];

        for (int i = 1; i <= n; i++) {
            data[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= n; i++) {
            min[firstLeaf + i -1] = data[i];
            max[firstLeaf + i -1] = data[i];
        }

        for (int i = firstLeaf - 1; i > 0; i--) {
            min[i] = Math.min(min[i * 2], min[i * 2 + 1]);
            max[i] = Math.max(max[i * 2], max[i * 2 + 1]);
        }


        for (int j = 1; j <= m; j++) {
            st = new StringTokenizer(br.readLine());
            int a, b;

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            int minResult = findMin(1, 1, firstLeaf, a, b);
            int maxResult = findMax(1, 1 ,firstLeaf, a, b);

            bw.append(minResult + " " + maxResult + "\n");
        }

        bw.flush();
    }
}
