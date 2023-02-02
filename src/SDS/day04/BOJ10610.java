package SDS.day04;

import java.util.Arrays;
import java.util.Scanner;

// 30
public class BOJ10610 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        char arr[] = sc.nextLine().toCharArray();

        int t = 0;

        Arrays.sort(arr);


        for(int i=arr.length - 1; i > 0; i-- ) {
            t += ( arr[i] - '0' ) % 3;
            sb.append(arr[i]);
        }

        if(arr[0] != '0' || (t % 3 != 0) )
        {
            System.out.println(-1);
            return;
        }

        sb.append('0');

        System.out.println(sb);

    }


}
