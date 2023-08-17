package groupStudy.day05.personal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 리모컨
 */
public class BOJ1107 {

    static boolean brokenButtons[] = new boolean[10];

    static List<Integer> buttons = new ArrayList<>();

    static int N;
    static int M;
    static int count;

    static final int START_POSITION = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bufferedReader.readLine());
        M = Integer.parseInt(bufferedReader.readLine());

        if (M != 0) {
            String[] s = bufferedReader.readLine().split(" ");
            for (int i = 0; i < M; i++) {
                int idx = Integer.parseInt(s[i]);
                brokenButtons[idx] = true;
            }
        }

        for (int i = 0; i < brokenButtons.length; i++) {
            if (!brokenButtons[i]) {
                buttons.add(i);
            }
        }

        count = Math.abs(START_POSITION - N);

        count = findCountToMove(N);
        System.out.println(count);
    }

    static int findCountToMove(int destination) {

        String destinationString = String.valueOf(destination);
        updateCount(destinationString, 0, "");
        return count;
    }

    static void updateCount(String dest, int depth, String current) {

        if (depth != 0) {
            count = Math.min(count, depth + Math.abs(Integer.parseInt(dest) - Integer.parseInt(current)));
        }

        if (depth > dest.length()) {
            return;
        }

        for (int i = 0; i < buttons.size(); i++) {
            updateCount(dest, depth + 1, current + buttons.get(i));
        }
    }





}
