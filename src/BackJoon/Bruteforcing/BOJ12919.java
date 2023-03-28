package BackJoon.Bruteforcing;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * A와 B 2
 */
public class BOJ12919 {

    static String S, T;
    static StringBuilder sb;
    
    static int length;

    static boolean equal = false;
    static void back(String now){

        // 탐색 종료 조건
        if (equal || now.length() <= length) {

            if (now.hashCode() == S.hashCode())
                equal = true;

            return;
        }
        
        // 1 ) 첫 문자가 'A'인 경우
        if (now.charAt(0) == 'A')
        {
            // 'A'로 시작하고 'B'로 끝나는 문자열은 만들 수 없으므로 탐색 종료
            if (now.charAt(now.length() - 1) == 'B')
                return;
            // 가장 뒤에 추가된 'A'를 제외
            back( now.substring(0, now.length()-1) );
        }
        else // if(now.charAt(0) =='B') 2) 첫 문자가 'B'인 경우
        {
            // 가장 마지막 문자가 'B'인 경우 앞에서 B를 제거하고 뒤집는다.
            if (now.charAt(now.length() - 1) == 'B') {
                sb = new StringBuilder( now.substring(1, now.length()) );
                back( sb.reverse().toString() );
            }
            else // if (now.length() -1 == 'A')
            {
                sb = new StringBuilder( now.substring(1, now.length()) );

                // 'B'가 마지막에 추가되어 뒤집어졌거나 'A'가 마지막에 추가된 경우
                back( sb.reverse().toString() );
                back( now.substring(0, now.length() - 1) );
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        S = bufferedReader.readLine();
        T = bufferedReader.readLine();
        length = S.length();

        back(T);

        if (equal)
            System.out.println(1);
        else
            System.out.println(0);
    }

}
