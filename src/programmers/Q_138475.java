package programmers;

import java.util.Arrays;

// 억억단을 외우자
public class Q_138475 {

    public static void main(String[] args) {
        Solution solution = new Solution();

    }



}
class Solution{

    // e 이하 모든 수의 약수를 저장하자
    int[] measure = new int[5000001];

    public void findMeasure() {
        // 자기 자신은 약수이므로 1을 넣어두고 시작
        Arrays.fill(measure, 1);

        for (int i = 2; i < measure.length; i++) {
            for (int j = 1; j * j <= i; j++) {

                if(i % j == 0 && j * j != i){
                    measure[i] += 2;
                }
                else if (j * j == i) {
                    measure[i]++;
                    break;
                }

            }
        }



    }

    public int[] solution(int e, int[] starts) {
        int[] answer = {};
        return answer;
    }
}
