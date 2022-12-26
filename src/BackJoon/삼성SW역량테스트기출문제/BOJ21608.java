package BackJoon.삼성SW역량테스트기출문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ21608 {

    static int N;

    static int mx[] = {1, -1, 0, 0};
    static int my[] = {0, 0, 1, -1};

    static int classRoom[][];

    static int sum=0;
    static Map<Integer, ArrayList<Integer>> preference;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        classRoom = new int[N+1][N+1];
        preference = new HashMap<>();
        StringTokenizer st;

        for( int i = 1; i <= Math.pow(N,2); i++){
            st = new StringTokenizer(br.readLine());

            int key = Integer.parseInt(st.nextToken());

            ArrayList<Integer> tmp = new ArrayList<>(); // 선호도

            for (int idx = 0; idx < 4; idx++)
            {
                tmp.add(Integer.parseInt(st.nextToken()));
            }
            preference.put(key, tmp);
            place(key);        // 배치();
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                int num = checkPreference(preference.get(classRoom[i][j]), new PlaceInfo(i, j, 0));
                if (num != 0) sum += Math.pow(10, num - 1);

            }
        }

        System.out.println(sum);
    }

    private static void place(int key) {
        int maxAdjPreference = 0; // 인접하는 것 중 좋아하는 수 -- 1번 조건
        int maxAdjEmpty = 0; // 인접하는 것 중 비어있는 칸 수 -- 2번 조건
        boolean checked = false;
        PlaceInfo maxInfo = new PlaceInfo();

        ArrayList<Integer> tmp = preference.get(key);

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {

                // 빈 자리가 아니면 continue;
                if(classRoom[i][j] != 0){
                    continue;
                }

                PlaceInfo placeInfo = new PlaceInfo(i, j, 0);

                int curPreference = checkPreference(tmp, placeInfo);

                if ( curPreference > maxAdjPreference ) {
                    maxAdjPreference = curPreference;
                    maxAdjEmpty = placeInfo.empty;
                    maxInfo = placeInfo;
                    checked = true;
                    continue;
                }
                else if (curPreference == maxAdjPreference && placeInfo.empty > maxAdjEmpty)
                {
                    maxAdjPreference = curPreference;
                    maxAdjEmpty = placeInfo.empty;
                    maxInfo = placeInfo;
                    checked = true;
                    continue;
                }

                if (!checked) {
                    maxInfo.x = i;
                    maxInfo.y = j;
                    checked = true;
                }

            }
        }
        classRoom[maxInfo.x][maxInfo.y] = key;
    }

    private static int checkPreference(ArrayList<Integer> arr, PlaceInfo placeInfo) {
        int cnt = 0;

        for (int i = 0; i < 4; i ++)
        {
            int xx = placeInfo.x + mx[i];
            int yy = placeInfo.y + my[i];

            if (0 < xx && xx < N + 1 && 0 < yy && yy < N + 1) {
                if(arr.contains(classRoom[xx][yy]))
                    cnt++;
                if (classRoom[xx][yy] == 0) {
                    placeInfo.empty++;
                }
            }
        }

    return cnt;
    }

    static class PlaceInfo{
        public PlaceInfo() {
        }

        public PlaceInfo(int x, int y, int empty) {
            this.x = x;
            this.y = y;
            this.empty = empty;
        }

        int x;
        int y;
        int empty; // 주변 빈 공간 확인
    }




}
