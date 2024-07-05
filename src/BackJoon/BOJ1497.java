package BackJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 기타콘서트
public class BOJ1497 {

    static String[] musicPerGuitar;
    static int N, M;
    static boolean[] isPlayed;
    static int min = -1;
    static int max = 0;

    static void play(int idx) {
        String music = musicPerGuitar[idx];
        for (int i = 0; i < music.length(); i++) {
            isPlayed[i] = (music.charAt(i) == 'Y' ? true : isPlayed[i]);
        }
    }

    static int findPlayList(){
        int num = 0;

        for (int i = 0; i < isPlayed.length; i++) {
            if(isPlayed[i])
                num++;
        }

         return num;
    }


    static void back(int now, int cnt){

        int num = findPlayList();

        if (num >= max) {

            if (num > max) {
                min = cnt;
                max = num;
            }
            else
                min = (min == -1 ? cnt : Math.min(cnt, min));
        }

        if (now >= N - 1) {
            return;
        }

        for (int i = now + 1; i < N; i++) {
            boolean tmp[] = isPlayed.clone();
            play(i);
            back(i, cnt + 1);
            isPlayed = tmp;
        }
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        musicPerGuitar = new String[N];
        isPlayed = new boolean[M];

        for (int i = 0; i < N; i++) {
            musicPerGuitar[i] = br.readLine().split(" ")[1];
        }

        back(-1, 0);

        System.out.println(min == 0 ? -1 : min);
    }

    public static void main(String[] args) throws Exception{
        new BOJ1497().solution();
    }
}
