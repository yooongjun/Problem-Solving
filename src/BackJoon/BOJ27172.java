package BackJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class BOJ27172 {

    static int N;
    static int arr[];

    static HashMap<Integer, Integer> map = new HashMap<>();
    private void findScore() {

        for (int i = 0; i < arr.length; i++) {
            int n = arr[i];
            for (int j = n * 2; j <= 1000000; j+=n) {

                if (map.containsKey(j)) {
                    map.replace(j, map.get(j) - 1);
                    map.replace(n, map.get(n) + 1);
                }
            }

        }

    }

    private void solution() throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        N = Integer.parseInt(bufferedReader.readLine());
        String[] s = bufferedReader.readLine().split(" ");
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(s[i]);
            map.put(arr[i], 0);
        }

        findScore();

        for (int i = 0; i < N; i++) {
            stringBuilder.append(map.get(arr[i]) + " ");
        }

        System.out.println(stringBuilder);
        bufferedReader.close();
    }

    public static void main(String[] args) throws Exception {
        new BOJ27172().solution();
    }

}
