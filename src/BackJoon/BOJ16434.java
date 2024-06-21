package BackJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 드래곤 앤 던전
public class BOJ16434 {

    static int N, H_atk;
    static Turn[] turns;
    static long answer;

    private boolean simulate(long maxHp) {
        long curHp = maxHp;
        long atk = H_atk;

        for (Turn turn : turns) {
            int t = turn.t;
            int a = turn.a;
            int h = turn.h;

            // 전투
            if (t == 1) {
                long i = h / atk;
                long j = h % atk;
                long cnt = ((j == 0) ? (i - 1) : (i));
                curHp -= (cnt) * a;
            } else {
                curHp = (Math.min(curHp + h, maxHp));
                atk += a;
            }

            if (curHp <= 0) {
                return false;
            }
        }
        return true;
    }

    private void findAnswer() {
        long l = 1;
        long r = 123456l * 1000000l * 1000000l;

        while (l <= r) {
            long mid = (l + r) / 2;

            if (simulate(mid)) {
                r = mid - 1;
                answer = mid;
            } else {
                l = mid + 1;
            }
        }
    }

    private void solution() throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        H_atk = Integer.parseInt(stringTokenizer.nextToken());

        turns = new Turn[N];

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int t = Integer.parseInt(stringTokenizer.nextToken());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int h = Integer.parseInt(stringTokenizer.nextToken());

            turns[i] = new Turn(t, a, h);
        }

        findAnswer();


        System.out.println(answer);
    }

    public static void main(String[] args) throws Exception {
        new BOJ16434().solution();
    }

    static class Turn{

        int t, a, h;

        public Turn(int t, int a, int h) {
            this.t = t;
            this.a = a;
            this.h = h;
        }
    }

}
