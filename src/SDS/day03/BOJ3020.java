package SDS.day03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 개똥벌레
public class BOJ3020 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int h = Integer.parseInt(s[1]);

        int sum[] = new int[h + 2];

        for(int i=0; i <n; i++) {
            int t = Integer.parseInt(br.readLine());

            if(i % 2 == 0 )
            {
                sum[1] ++;
                sum[t + 1] --;
            }
            else
            {
                sum[h - t + 1]++;
            }
        }

        int min = 5000001;

        for(int i=1; i <= h; i++)
        {
            sum[i] += sum[i-1];
            min = Math.min(sum[i], min);
        }

        int cnt = 0;
        for(int i=1; i  <= h; i++)
        {
            if(min == sum[i])
                cnt++;
        }
        System.out.println(min +" " + cnt);

    }


}
