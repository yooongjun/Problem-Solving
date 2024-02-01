package BackJoon;

import java.util.*;
import java.io.*;

// 예산
public class BOJ2512 {

    static int N,M;
    static int arr[];
    static int max = 0;
    static int total = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        N = Integer.parseInt(bufferedReader.readLine());
        arr = new int[N];

        String s[] = bufferedReader.readLine().split(" ");
        M = Integer.parseInt(bufferedReader.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(s[i]);
            total += arr[i];
            max = Math.max(max, arr[i]);
        }

        if(total <= M){
            result = max;
        }
        else{
            result = binarySearch();
        }

        System.out.println(result);
    }

    static int binarySearch() {
        int result = 0;
        int left = 1;
        int right = max;

        while (left <= right){
            int mid = (left + right)/2;

            if (canSupply(mid)) {
                result = Math.max(result, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    static boolean canSupply(int budget){
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += (budget < arr[i] ? budget : arr[i]);

            if (sum > M) {
                return false;
            }
        }

        return true;
    }

}
