package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

// 카드 제거
public class D4_Q14557{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());

        ArrayList<Boolean> list;

        for (int i = 1; i <= T; i++) {
            int cnt = 0;
            list = new ArrayList<>();
            String s = sc.nextLine();

            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (c == '1') {
                    cnt ++;
                    list.add(true);
                }
                else
                    list.add(false);
            }

            if (!list.contains(true)) {
                System.out.println("#"+i+" "+"no");
            }
            else if (cnt % 2 == 0) {
                System.out.println("#" + i + " " + "no");
            } else {
                System.out.println("#" + i + " " + "yes");
            }

        }
    }

}
