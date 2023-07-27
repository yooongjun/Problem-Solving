package groupStudy.day01.implementation.personal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 욕심쟁이 돼지
 */
public class BOJ3060 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(bufferedReader.readLine());
            String s[] = bufferedReader.readLine().split(" ");
            int arr[] = new int[6];
            int need = 0;
            int day = 1;

            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(s[i]);
                need += arr[i];
            }

            while (true){
                if(need > N) break;
                need = 0;
                int tmp[] = arr.clone();

                for (int i = 0; i < 6; i++) {
                    need += arr[i] += tmp[(i-1)<0?5:i-1] + tmp[(i+1)>5?0:i+1] + tmp[(i>2)?(i-3):(i+3)];
                }

                day++;
            }
            System.out.println(day);
        }


    }




}
