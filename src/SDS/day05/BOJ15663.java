package SDS.day05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ15663 {

    static int n, m;
    static int [] arr;
    static int[] result;
    static boolean[] visit;
    static Set<String> set = new LinkedHashSet<>();

    static StringBuilder sb;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visit = new boolean[n+1];
        arr = new int[n + 1];
        result = new int[m + 1];

        st = new StringTokenizer(br.readLine());

        for(int i=1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        back(0);
        for(String s : set)
            System.out.println(s);
    }

    static void back(int x){


        if(x == m)
        {
            sb = new StringBuilder();

            sb.append(result[1]);
            for(int i=2; i<=m; i++)
                sb.append(" "+result[i]);

            set.add(sb.toString());
            return ;
        }

        for(int i=1; i < arr.length; i++) {
            if(visit[i])
                continue;
            visit[i] = true;
            result[x + 1] = arr[i];
            back(x+1);
            visit[i] = false;

        }

    }




}
