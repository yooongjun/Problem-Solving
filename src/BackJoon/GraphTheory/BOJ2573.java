package BackJoon.GraphTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 빙산
public class BOJ2573 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int mx[] = {-1, 0, 1, 0};
        int my[] = {0, 1, 0, -1};
        int map[][] = new int[N][M];
        Queue<node> queue = new LinkedList<>();
        int year = 0;

        for(int i=0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

                // 빙산인 경우 조사할 큐에 추가
                if(map[i][j] > 0){
                    queue.add(new node(i,j));
                }
            }
        }

        int cnt = queue.size();
        List<node> meltPlace = new ArrayList<>();

        // 로직 실행
        while (!queue.isEmpty()){
            node cur = queue.poll();
            int adjSeaCnt = 0;

            // 네 방향 조사
            for( int i =0; i < 4; i++){
                int xx = cur.x + mx[i];
                int yy = cur.y + my[i];

                if (xx >= 0 && xx < N && yy >= 0 && yy <= M && map[xx][yy] == 0) {
                    adjSeaCnt++;
                }
            }

            if (map[cur.x][cur.y] <= adjSeaCnt)
                meltPlace.add(cur);
            else {
                map[cur.x][cur.y] -= adjSeaCnt;
                queue.add(cur);
            }

            cnt--;

            // 큐를 한바퀴 돌았으면 녹이고 빙산의 수 세기
            if(cnt == 0)
            {
                cnt = queue.size();
                year++;

                for (int i = 0; i < meltPlace.size(); i++) {
                    map[ meltPlace.get(i).x ][ meltPlace.get(i).y ] = 0;
                }

                meltPlace.clear();

                boolean check[][] = new boolean[N][M];
                Queue<node> checkQueue = new LinkedList<>();

                // 전부 녹은 경우
                if (queue.isEmpty()) {
                    year = 0;
                    break;
                }

                checkQueue.add(new node(queue.peek().x, queue.peek().y));
                check[queue.peek().x][queue.peek().y] = true;

                int trueCnt = 0;

                while (!checkQueue.isEmpty()) {

                    node start = checkQueue.poll();
                    for (int i = 0; i < 4; i++) {

                        int xx = start.x + mx[i];
                        int yy = start.y + my[i];

                        if (xx >= 0 && xx < N && yy >= 0 && yy < M && map[xx][yy] > 0 && !check[xx][yy]) {
                            checkQueue.add(new node(xx, yy));
                            check[xx][yy] = true;
                            trueCnt++;
                        }
                    }
                }

                if (trueCnt != queue.size() - 1) {
                    break;
                }
            }
        }

        System.out.println(year);
    }

    static class node{

        int x;
        int y;

        node(int x, int y){

            this.x = x;
            this.y = y;

        }

    }

}
