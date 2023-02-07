package SDS.day07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// 플로이드
// 플로이드 와셜 알고리즘 사용
public class BOJ11404 {

    static int[][] map = new int[101][101];
    static int n, m;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        for(int i = 0; i< m; i++) {
            String s[] = br.readLine().split(" ");
            int a, b, c;
            a = Integer.parseInt(s[0]);
            b = Integer.parseInt(s[1]);
            c = Integer.parseInt(s[2]);
            if(map[a][b] != 0)
                map[a][b] = Math.min(map[a][b], c);
            else
                map[a][b] = c;
        }


        floyd();

        for(int i = 1; i <=n; i++) {
            for(int j = 1; j <n ; j++)
                System.out.print(map[i][j] + " ");
            System.out.println(map[i][n]);
        }

    }

    static void floyd() {

        // 중간 노드 : i
        for(int i = 1; i <=  n; i++) {
            // 조사하는 거리  j -> k
            for(int j = 1; j <= n; j++) {
                for(int k = 1; k <= n; k++) {

                    if(map[j][i] == 0 || i == j)
                        break;

                    if(j == k || map[i][k] == 0)
                        continue;

                    map[j][k] =  ( ( map[j][k] != 0 ) ? Math.min( map[j][k], map[j][i] + map[i][k] ) : (map[j][i] + map[i][k]) );

                }

            }
        }

    }


}
