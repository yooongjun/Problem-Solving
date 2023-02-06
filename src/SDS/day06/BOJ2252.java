package SDS.day06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 줄 세우기
// 위상정렬
public class BOJ2252 {

    static int n,m;
    static List<Integer> adjList[];
    static int degree[];
    static boolean visit[];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s[] = br.readLine().split(" ");
        Queue<Integer> queue = new LinkedList<>();


        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);


        adjList = new ArrayList[n+1];
        degree = new int[n+1];

        for(int i = 1; i < n+1; i++)
        {
            adjList[i] = new ArrayList<>();
        }

        for(int i = 0; i <m; i++) {
            int a, b;
            s = br.readLine().split(" ");
            a= Integer.parseInt(s[0]);
            b= Integer.parseInt(s[1]);

            adjList[a].add(b);
            degree[b]++;
        }

        for(int i = 1; i < n+1; i++) {
            if(degree[i] == 0)
                queue.add(i);
        }

        while(!queue.isEmpty()) {
            int n = queue.poll();

            bw.append(n+" ");

            for(int j=0; j < adjList[n].size(); j++)
            {
                degree[adjList[n].get(j)]--;
                if(degree[adjList[n].get(j)] == 0)
                    queue.add(adjList[n].get(j));
            }
        }

        bw.flush();
    }

}
