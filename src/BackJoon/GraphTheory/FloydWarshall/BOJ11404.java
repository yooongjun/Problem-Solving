package BackJoon.GraphTheory.FloydWarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 플로이드
public class BOJ11404 {

    static int n;
    static int m;
    static int INF;

    static int distance[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        INF = n * 100000 + 1;
        distance = new int[n + 1][n + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if(i != j)
                    distance[i][j] = INF;
            }
        }


        for (int i = 1; i <= m; i++) {
            String[] s = br.readLine().split(" ");
            int n1 = Integer.parseInt(s[0]);
            int n2 = Integer.parseInt(s[1]);
            int n3 = Integer.parseInt(s[2]);

            distance[n1][n2] = Math.min(distance[n1][n2], n3);
        }

        floyd();

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                System.out.print((distance[i][j] == INF ? 0 : distance[i][j]) + (j == n ? "" : " "));
            }
            System.out.println();
        }
    }

    static void floyd(){

        for (int i = 1; i < n+1; i++){
            for(int j = 1; j < n+1; j++){
                for (int k = 1; k < n + 1; k++) {
                    if(i == j)
                        break;
                    if (distance[j][i] == INF || j == k) {
                        continue;
                    }

                    distance[j][k] = Math.min(distance[j][i] + distance[i][k], distance[j][k]);
                }
            }
        }
    }

}
