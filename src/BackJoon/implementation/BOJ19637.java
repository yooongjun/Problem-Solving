package BackJoon.implementation;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 19637번 - IF문 좀 대신 써줘
 */
public class BOJ19637 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        int power[] = new int[n];
        String powerName[] = new String[n];
        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            powerName[i] = input[0];
            power[i] = Integer.parseInt(input[1]);

            if (!map.containsKey(power[i])) {
                map.put(power[i], powerName[i]);
            }
        }

        for (int i = 0; i < m; i++) {
            int v = Integer.parseInt(br.readLine());
            int idx = binarySearch(power, v);
            bw.write(map.get(power[idx]) + "\n");
        }

        bw.flush();
    }

    static int binarySearch(int arr[], int value) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] > value) {
                right = mid - 1;
            } else if (arr[mid] < value) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return arr[left] < value ? left +1 : left;
    }

}
