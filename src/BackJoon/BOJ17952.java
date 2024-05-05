package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 과제가 끝나지 않아!
public class BOJ17952 {

    static int n;
    static Task currentTask;
    static int totalScore = 0;
    static Stack<Task> remains = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {
            String[] s = bufferedReader.readLine().split(" ");

            int tmp = Integer.parseInt(s[0]);

            if (tmp == 0) {

            }
            else if (tmp == 1)
            {
                if (currentTask != null && currentTask.time > 0) {
                    remains.add(currentTask);
                }

                int score = Integer.parseInt(s[1]);
                int time = Integer.parseInt(s[2]);
                currentTask = new Task(time, score);
            }

            if (currentTask != null) {
                currentTask.time--;
                if (currentTask.time == 0) {
                    totalScore += currentTask.score;
                    currentTask = null;
                }
            }
        }


    }

    static class Task{
        int time;
        int score;

        public Task(int time, int score) {
            this.time = time;
            this.score = score;
        }
    }

}
