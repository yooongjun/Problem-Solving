package SDS.day01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// 암호 만들기
public class BOJ1759 {

    static int l, c;
    static char[] arr;
    static boolean[] visit;
    static char[] output;
    static ArrayList<Character> aeiou;

    public static void main(String[] args){

        Scanner sc= new Scanner(System.in);
        l = sc.nextInt();
        c = sc.nextInt();

        output = new char[l];
        visit = new boolean[c];
        aeiou = new ArrayList<>();

        aeiou.add('a');
        aeiou.add('e');
        aeiou.add('i');
        aeiou.add('o');
        aeiou.add('u');


        sc.nextLine();

        String s = sc.nextLine();

        s= s.replace(" ", "");
        arr = s.toCharArray();

        Arrays.sort(arr);
        back(0,0);
    }


    private static void back(int x, int idx) {

        if(x == l)
        {
            int c1 = 0;
            int c2 = 0;
            for(int i=0; i < output.length; i++) {
                if(aeiou.contains(output[i]))
                    c1++;
                else
                    c2++;
            }

            if(c1 > 0 && c2 > 1)
            {
                for(int i=0; i <output.length; i++) {
                    System.out.print(output[i]);
                }
                System.out.println();
            }

            return ;
        }

        for(int i=idx; i <= c - (l - x) ; i++) {
            if(!visit[i]) {
                visit[i] = true;
                output[x] = arr[i];
                back(x+1, i);
                visit[i] = false;
            }
        }

    }
}
