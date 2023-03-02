package BackJoon;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 좌표 압축
 */
public class BOJ18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        int data[] = new int[n];
        int arr[] = new int[n];
        int rank[] = new int[n];

        String[] s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = data[i] = Integer.parseInt(s[i]);
        }

        Arrays.sort(arr);

        int t = 0;
        for (int i = 0; i < n; i++) {
            if(!map.containsKey(arr[i]))
                map.put(arr[i], t++);
        }

        for (int i = 0; i < n; i++) {
           rank[i] =  map.get(data[i]);
        }

        for (Integer i : rank) {
            bw.append(i + " ");
        }

        bw.flush();





    }
}
