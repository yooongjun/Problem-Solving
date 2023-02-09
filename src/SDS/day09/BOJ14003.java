package SDS.day09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 가장 긴 증가하는 부분 수열
// DP + 이분탐색
public class BOJ14003 {

    static int num[];
    static int n;
    static int D[];
    static int P[];
    static int lengthD = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        num = new int[n+1];
        D = new int[n+1];
        P = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =1 ; i <= n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        // D 초기 정보 입력
        D[1] = num[1];
        P[1] = 1;
        // D의 길이
        lengthD++;

        // 배열을 순회하며 그 숫자가 들어갈 자리를 저장
        for(int i= 2; i <= n; i++) {

            // 해당 배열에서 들어갈 인덱스를 반환
            int t = binarySearch(D, num[i], 1, lengthD );

            // 지금까지 수들보다 더 큰 수가 오면
            if( t > lengthD) {
                lengthD++;
                D[lengthD] = num[i];
                P[i] = lengthD;
            }
            else {
                D[t] = num[i];
                P[i] = t;
            }
        }

        List<Integer> result = new ArrayList<>();

        for(int i = n; i > 0; i--) {
            if(P[i] == lengthD) {
                result.add(num[i]);
                lengthD --;
            }
        }

        System.out.println(result.size());
        for(int i = result.size() - 1; i >= 1; i--)
            System.out.print(result.get(i) + " ");
        System.out.print(result.get(0));

    }

    static int binarySearch(int[] D, int findNum, int left, int right) {
        int mid;

        while(left <= right) {
            mid = (left+right)/2;

            if(D[mid] < findNum) {
                left = mid + 1;
            }
            else if(D[mid] > findNum) {
                right = mid - 1;
            }
            else
            {
                // 값이 같은 경우
                return mid;
            }
        }
        // 숫자가 들어갈 자리
        return left;

    }


}
