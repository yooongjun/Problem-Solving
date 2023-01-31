package BackJoon;

import java.util.*;

// A와 B2
public class BOJ12919 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        String T = sc.nextLine();
        int idx = 0;

        while (true){

            if (T.length() == S.length()) {
                System.out.println(T.equals(S) ? 1 : 0);
                break;
            }

            if(T.charAt(0) == 'A'){
                T = trimStr(T);
            } else if (T.charAt(0) == 'B') {
                T = reverseString(T);
            }

        }
    }

    public static String reverseString(String T){
        StringBuilder tmp = new StringBuilder();

        for (int i = 1; i < T.length() ; i++) {
            tmp.append(T.charAt(i));
        }

        return tmp.reverse().toString();
    }

    public static String trimStr(String T){
        StringBuilder tmp = new StringBuilder();

        for (int i = 1; i < T.length(); i++) {
            tmp.append(T.charAt(i));
        }

        return tmp.toString();
    }

}
