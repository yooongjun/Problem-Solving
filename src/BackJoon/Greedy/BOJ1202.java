package BackJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 보석 도둑
public class BOJ1202 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long result = 0l;

        int backPack[] = new int[K];
        PriorityQueue<Jewelry> jewelries = new PriorityQueue<>((Jewelry o1, Jewelry o2) -> o1.m - o2.m);
        PriorityQueue<Integer> values = new PriorityQueue<>(Collections.reverseOrder());

        // 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            jewelries.add(new Jewelry(m, v));
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            backPack[i] = Integer.parseInt(st.nextToken());
        }

        // 오름차순 정렬
        Arrays.sort(backPack);

        for (int i = 0; i < K; i++) {

            while (!jewelries.isEmpty()) {
                if (jewelries.peek().m <= backPack[i]) {
                    values.add(jewelries.poll().v);
                    continue;
                }

                break;
            }

            if(!values.isEmpty())
                result += values.poll();
        }

        System.out.println(result);
    }


    public static class Jewelry{
        int m;
        int v;

        public Jewelry(int m, int v) {
            this.m = m;
            this.v = v;
        }

    }





}
