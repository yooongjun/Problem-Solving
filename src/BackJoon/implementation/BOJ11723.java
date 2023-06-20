package BackJoon.implementation;

import java.io.*;
import java.util.*;

/**
 * 집합
 */
public class BOJ11723 {

    static HashSet<Integer> set = new HashSet<>();
    static List<Integer> all = new ArrayList<>(Arrays.asList(1, 2, 3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20));
    static BufferedWriter bw ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int m = Integer.parseInt(br.readLine());

        while (m-- > 0) {
            String[] s = br.readLine().split(" ");
            int val = 0;
            if (s.length > 1) {
                val = Integer.parseInt(s[1]);
            }
            func(s[0], val);
        }

        bw.flush();
    }

    public static void func(String command, int val) throws IOException {

        switch (command) {
            case "add":
                set.add(val);
                break;
            case "remove":
                set.remove(val);
                break;
            case "check":
                if(set.contains(val)) bw.append(1 + "\n");
                else bw.append(0 + "\n");
                break;
            case "toggle":
                if(set.contains(val)) set.remove(val);
                else set.add(val);
                break;
            case "all":
                set.clear();
                set.addAll(all);
                break;
            case "empty":
                set.clear();
                break;
        }
    }
}
