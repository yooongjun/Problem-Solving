package BackJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 가장 긴 증가하는 부분 수열 2
public class BOJ12015 {

    static int A[];
    static int N;
    static List<Integer> LIS;

    private int binarySearch(List<Integer> list, int key) {
        int l = 0;
        int r = list.size() - 1;

        while (l <= r) {
            int mid = (l + r) / 2;

            int midVal = list.get(mid);

            if (midVal > key) {
                r = mid - 1;
            } else if (midVal < key) {
                l = mid + 1;
            } else {
                l = mid;
                break;
            }
        }

        return l;
    }


    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        LIS = new ArrayList<>();
        A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        LIS.add(A[0]);

        for (int i = 1; i < N; i++) {
            int idx = binarySearch(LIS, A[i]);
            if (idx == LIS.size())
                LIS.add(A[i]);
            else
                LIS.set(idx, A[i]);
        }

        System.out.println(LIS.size());
    }

    public static void main(String[] args) throws Exception {
        new BOJ12015().solution();
    }


}
