package programmers;
import java.util.*;

public class Q_131701 {

    public int solution(int[] elements) {
        int answer = 0;
        int sum[] = new int[elements.length];
        HashSet<Integer> set = new HashSet<>();

        for (int i = 1; i <= elements.length; i++) {

            // start : 부분 수열의 시작 인덱스
            for (int start = 0; start < elements.length; start++) {
                sum[start] += elements[(start + i - 1) % elements.length];
                set.add(sum[start]);
            }
        }

        answer = set.size();
        return answer;
    }
}
