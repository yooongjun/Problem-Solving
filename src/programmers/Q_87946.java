package programmers;

import java.util.*;

class Q_87946 {

    static boolean visit[];
    static int max = 0;

    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        visit = new boolean[dungeons.length];

        back(k, dungeons, 0, 0);

        answer = max;

        return answer;
    }


    public void back(int k, int[][] dungeons, int count, int now){

        for(int i = 0; i < dungeons.length; i++){
            if(!visit[i] && dungeons[i][0] <= k){
                visit[i] = true;
                back(k - dungeons[i][1], dungeons, count + 1, i);
                max = Math.max(max, count + 1);
                visit[i] = false;
            }
        }
    }

}