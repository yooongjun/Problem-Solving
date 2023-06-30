package BackJoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 크로스 컨트리
 */
public class BOJ9017 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine());

        for (int T = 0; T < t; T++) {
            int n = Integer.parseInt(bufferedReader.readLine());
            String[] s = bufferedReader.readLine().split(" ");
            int arr[] = new int[n];
            Map<Integer, Integer> teamCnt = new HashMap<>();
            Map<Integer, Integer> teamScore = new HashMap<>();
            Map<Integer, Integer> five = new HashMap<>();
            List<Integer> underSix = new ArrayList<>();
            int score = 1;
            int min = Integer.MAX_VALUE;
            int min_five = Integer.MAX_VALUE;
            int result = 0;

            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(s[i]);
                if (teamCnt.containsKey(arr[i]))
                    teamCnt.replace(arr[i], teamCnt.get(arr[i]) + 1);
                else
                    teamCnt.put(arr[i], 1);
            }

            for (Integer i : teamCnt.keySet()) {
                if (teamCnt.get(i) < 6) {
                    underSix.add(i);
                }
            }

            teamCnt.clear();

            for (int i = 0; i < arr.length; i++) {

                if(underSix.contains(arr[i])) continue;

                if (teamScore.containsKey(arr[i]))
                {

                    teamCnt.replace(arr[i], teamCnt.get(arr[i]) + 1);

                    if(teamCnt.get(arr[i]) < 5) teamScore.replace(arr[i], teamScore.get(arr[i]) + score);

                    if (teamCnt.get(arr[i]) == 5)
                    {
                        five.put(arr[i], score);
                    }
                }
                else
                {
                    teamScore.put(arr[i], score);
                    teamCnt.put(arr[i], 1);
                }

                    score++;
            }


            for (Integer i : teamScore.keySet()) {

                Integer cur = teamScore.get(i);
                Integer cur_five = five.get(i);

                if (min > cur) {
                    min = cur;
                    min_five = cur_five;
                    result = i;
                }

                if (cur == min && min_five > cur_five){
                    min_five = cur_five;
                    result = i;
                }
            }

            System.out.println(result);
        }
    }

}
