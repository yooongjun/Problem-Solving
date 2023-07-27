package groupStudy.day01.implementation.group;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * S3 프린터 큐
 */
public class BOJ1966 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bufferedReader.readLine());

        for (int t = 0; t < T; t++) {
            // input
            String[] s = bufferedReader.readLine().split(" ");
            int N = Integer.parseInt(s[0]);
            int M = Integer.parseInt(s[1]);
            String[] input  = bufferedReader.readLine().split(" ");

            Queue<Info> queue = new LinkedList<>();
            int result = 0;
            int[] cnt = new int[10];            // 중요도별 문서 수 세기

            // Queue 초기화 및 중요도 수 count
            for (int i = 0; i < N; i++) {
                int p = Integer.parseInt(input[i]);
                // i: 초기 Queue 순서, p: 중요도 
                queue.add(new Info(i, p));
                cnt[p]++;
            }

            while (!queue.isEmpty()) {
                Info now = queue.poll();
                boolean isFirst = true;

                // 가장 앞에 있는 문서(now)의 중요도보다 높은 문서가 있는지 확인
                for (int i = now.p + 1; i < 10; i++) {
                    // 높은 문서가 존재하는 경우 
                    if (cnt[i] > 0) {
                        isFirst = false;
                        break;
                    }
                }

                // 위에서 확인한 결과로 만약 중요도가 높은 문서가 있으면 Queue에 마지막에 재배치
                if (!isFirst) {
                    queue.add(now);
                    continue;
                }

                // 현재 문서보다 높은 중요도가 없는 경우 꺼내는 순서와 count값 조정
                result++;
                cnt[now.p]--;
                
                // 현재 꺼낸 문서가 찾던 문서이면 반복 종료
                if(M == now.num) break;
            }

            System.out.println(result);
        }
    }

    static class Info{
        int num;    // 초기 순서
        int p;      // 중요도

        public Info(int num, int p) {
            this.num = num;
            this.p = p;
        }
    }


}
