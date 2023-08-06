package groupStudy.day03.greedy.group;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

/**
 * 로프
 */
public class BOJ2217 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());

        Integer[] ropes = new Integer[N];

        for (int i = 0; i < ropes.length; i++) {
            int length = Integer.parseInt(bufferedReader.readLine());
            ropes[i] = length;
        }

        // 로프의 길이로 내림차순 정렬
        Arrays.sort(ropes, Collections.reverseOrder());

        int maxWeight = 0;

        for (int i = 0; i < ropes.length; i++) {

            // i번째 로프를 사용하는 경우 최대 무게
            int weightUsingI = (i + 1) * ropes[i];

            maxWeight = Math.max(maxWeight, weightUsingI);

        }

        System.out.println(maxWeight);
    }

}
