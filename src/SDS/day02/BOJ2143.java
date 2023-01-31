package SDS.day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ2143 {

    static int[] A;
    static int[] B;
    static List<Long> subSum_B = new ArrayList<>();
    static List<Long> subSum_A = new ArrayList<>();

    static long[] sum_A;
    static long[] sum_B;

    static int t;
    static long cnt = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        A = new int[n];
        String s[] = br.readLine().split(" ");

        // A 입력
        for(int i=0; i < n; i++) {
            A[i] = Integer.parseInt(s[i]);
        }

        n = Integer.parseInt(br.readLine());
        B = new int[n];
        s = br.readLine().split(" ");

        // B 입력
        for(int i=0; i <n ; i++) {
            B[i] = Integer.parseInt(s[i]);
        }

        // 부배열의 합 저장
        for(int i=0; i < A.length; i++) {
            long tmp = 0;
            for(int j=i; j < A.length; j++) {
                tmp += A[j];
                subSum_A.add(tmp);
            }
        }

        for(int i=0; i < B.length; i++) {
            long tmp = 0;
            for(int j=i; j < B.length; j++) {
                tmp += B[j];
                subSum_B.add(tmp);
            }
        }

        Collections.sort(subSum_A);
        Collections.sort(subSum_B);
        tp();

        System.out.println(cnt);
    }


    static void tp() {

        int i = 0;
        int j = subSum_B.size()-1;

        while(i < subSum_A.size() && j >= 0) {

            long sum = subSum_A.get(i) + subSum_B.get(j);


            if(sum > t)
                j--;
            else if(sum < t)
                i++;
            else { //(sum == t)
                // 중복 찾기
                long t1 = subSum_A.get(i);
                long t2 = subSum_B.get(j);
                // 개수
                long cA =0, cB = 0;

                while(i < subSum_A.size()) {
                    if(subSum_A.get(i) == t1)
                    {
                        cA++;
                    }
                    else
                        break;
                    i++;
                }

                while(j >= 0) {
                    if(subSum_B.get(j) == t2)
                    {
                        cB++;
                    }
                    else
                        break;
                    j--;
                }

                cnt += cA * cB;
            }
        }
    }




}
