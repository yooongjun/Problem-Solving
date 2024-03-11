import java.io.*;

// 펠린드롬수
public class BOJ1259 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String s = bufferedReader.readLine();

            if (s.equals("0")) {
                break;
            }

            bufferedWriter.append((isPalindrome(s)? "yes" : "no") + "\n");
        }

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }

    static boolean isPalindrome(String s) {
        String reverseS = new StringBuffer(s).reverse().toString();

        if (s.equals(reverseS)) {
            return true;
        }

        return false;
    }

}
