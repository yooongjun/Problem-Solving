package BackJoon.GraphTheory.FloydWarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 키순서
public class BOJ2458 {
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s[] = br.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        int visit[][] = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            s = br.readLine().split(" ");
            visit[Integer.parseInt(s[0])][Integer.parseInt(s[1])]  = 1;
            visit[Integer.parseInt(s[1])][Integer.parseInt(s[0])] = -1;
        }

        for (int i = 1; i < N+1; i++){
            for(int j = 1; j < N+1; j++){
                for (int k = 1; k < N+1; k++){

                    if(i == j){
                        break;
                    }

                    if(j == k || i == k ||visit[i][k] == 0){
                        continue;
                    }

                    if(visit[j][i] < 0 && visit[i][k] < 0)
                        visit[j][k] = Math.min(visit[j][k], visit[j][i] + visit[i][k]);

                    else if(visit[j][i] > 0 && visit[i][k] > 0)
                        visit[j][k] = Math.max(visit[j][k], visit[j][i] + visit[i][k]);


                }
            }
        }

        int result = 0;
        for (int i = 1; i < N + 1; i++) {
            boolean key = true;
            for (int j = 1; j < N + 1; j++) {
                if (i != j && visit[i][j] == 0) {
                    key = false;
                    break;
                }
            }

            if (key)
                result++;
        }
        System.out.println(result);

    }

    private static void prirntArr(int[][] visit) {
        for (int i = 1; i < N + 1; i++) {
            System.out.println();
            for (int j = 1; j < N + 1; j++) {
                if (i == j) {
                    System.out.print(0 + " ");
                } else {
                    System.out.print(((visit[i][j] == 0) ? "INF" : visit[i][j]) +" ");
                }
            }

        }
    }

}
