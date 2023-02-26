package BackJoon.GraphTheory.Dijkstra;


import java.io.*;
import java.util.*;

/**
 * 탈옥
 * 상하좌우 1줄씩 생성하여 1) 상근이가 밖에서 열어주는 경우를 고려, 2) 죄수 1에서의 경로 3) 죄수 2에서의 경로를 각각 더해줌
 */
public class BOJ9376 {


    static int mx[] = {0, -1, 0, 1};
    static int my[] = {-1, 0, 1, 0};

    static int t, h, w;
    static char map[][];
    // x: 상근이가 문을 열어 찾는 경우
    // y, z : 죄수 1 ,2 가 각각 문을 열어 찾는 경우
    static int distance_x[][];
    static int distance_y[][];
    static int distance_z[][];

    // 시작지점
    static ArrayList<Integer> start_x;
    static ArrayList<Integer> start_y;
    static final int INF = 20000;
    static int answer;

    public static void dijkstra(int x, int y, int[][] distance){

        PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> e1.cost - e2.cost);

        pq.add(new Edge(x,y,0));

        while (!pq.isEmpty()){
            Edge now = pq.poll();

            for (int i = 0; i < 4; i++) {
                int xx = now.x + mx[i];
                int yy = now.y + my[i];

                if(xx >= 0 && xx <= h+1 && yy >= 0 && yy <= w+1){

                    // 죄수인 칸도 지나갈 수 있도록 처리
                    if ( (map[xx][yy] == '.' || map[xx][yy] == '$' ) && (distance[xx][yy] > now.cost)) {
                        distance[xx][yy] = now.cost;
                        pq.add(new Edge(xx, yy, now.cost));
                    }
                    else if (map[xx][yy] == '#' && (distance[xx][yy] > now.cost + 1))
                    {
                        distance[xx][yy] = now.cost + 1;
                        pq.add(new Edge(xx, yy, now.cost + 1));
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            answer = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            start_x = new ArrayList<>();
            start_y = new ArrayList<>();
            distance_x = new int[h + 2][w + 2];
            distance_y = new int[h + 2][w + 2];
            distance_z = new int[h + 2][w + 2];
            map = new char[h + 2][w + 2];

            for (int j = 0; j <= h + 1; j++) {
                String s = "";
                if(j != 0 && j != h+1) {
                    s = br.readLine();
                }

                for (int k = 0; k <= w + 1; k++) {

                    if(j==0 || k == 0 || j == h+1 || k == w + 1){
                        map[j][k] = '.';
                        continue;
                    }
                    map[j][k] = s.charAt(k-1);
                    if (map[j][k] == '$') {
                        start_x.add(j);
                        start_y.add(k);
                    }
                }
            }

            for(int j = 0; j <= h+1; j++) {
                Arrays.fill(distance_x[j], INF);
                Arrays.fill(distance_y[j], INF);
                Arrays.fill(distance_z[j], INF);
            }



            dijkstra( 0, 0, distance_x);
            dijkstra(start_x.get(0), start_y.get(0), distance_y);
            dijkstra(start_x.get(1), start_y.get(1), distance_z);

            answer = 50000;

            for (int p = 1; p < h + 1; p++) {
                for (int q = 1; q < w + 1; q++) {
                    if(map[p][q] == '*')
                        continue;

                    int tmp = distance_x[p][q] + distance_y[p][q] + distance_z[p][q];

                    if(map[p][q] == '#')
                            tmp -= 2;

                    answer = Math.min(answer, tmp);
                }
            }

            bw.append(answer + "\n");
        }

        bw.flush();
    }

    static class Edge{

        int x;
        int y;
        int cost;

        Edge(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }


    }

}
