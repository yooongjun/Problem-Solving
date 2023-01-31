package SDS.day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

// 나무 자르기
public class BOJ2805 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        long m = Long.parseLong(s[1]);
        Integer arr[] = new Integer[n + 1];

        s = br.readLine().split(" ");

        for(int i = 0; i < arr.length - 1; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        arr[arr.length -1 ] = 0;

        Arrays.sort(arr, Collections.reverseOrder());


        long treeHeight = arr[0];
        long sum = 0;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] < treeHeight) {
                if( (treeHeight - arr[i]) * i > ( m- sum ) )
                {
                    treeHeight = treeHeight - ( ( (m - sum) % i == 0 ) ? (m - sum) / i : ((m-sum) / i + 1) );
                    break;
                }
                else if((treeHeight - arr[i]) * i < m )
                {
                    sum += (treeHeight - arr[i])*i;
                    treeHeight = arr[i];
                }
                else {
                    treeHeight = 0;
                    break;
                }
            }
        }

        System.out.println(treeHeight);
    }

}
