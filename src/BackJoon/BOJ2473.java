package BackJoon;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 세 용액
public class BOJ2473 {

    static long INF = 3000000001l;
    static int N;
    static int[] arr;

    static long min = INF;

    static int[] answer = {-1, -1, -1};

    private void twoPointer(int a) {
        int b = a + 1;
        int c = N - 1;

        while (c > b) {

            long sum = (long)arr[a] + arr[b] + arr[c];
            long abs = Math.abs(sum);

            if (abs < min) {
                min = abs;
                answer[0] = a;
                answer[1] = b;
                answer[2] = c;
            }

            if (sum < 0) {
                b++;
            } else if (sum > 0) {
                c--;
            } else {
                return;
            }
        }



    }


    private void binarySearch(int l, int r, int a, int b) {

        long val = arr[a] + arr[b];

        while (l <= r) {
            int mid = (l + r) / 2;
            long sum = val + arr[mid];

            if (Math.abs(sum) < Math.abs(min)) {
                min = Math.abs(sum);
                answer[0] = a;
                answer[1] = b;
                answer[2] = mid;
            }

            if (sum < 0) {
                l = mid + 1;
            } else if (sum > 0) {
                r = mid - 1;
            } else {
                return;
            }

        }
    }


    private void solution_tp() throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            twoPointer(i);
        }

        System.out.println(arr[answer[0]] + " " + arr[answer[1]] + " " + arr[answer[2]]);
    }


    // binarySearch 풀이
    private void solution_bs() throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if(j + 1 < N) {
                    binarySearch(j + 1, N - 1, i, j);
                }
            }
        }

        System.out.println(arr[answer[0]] + " " + arr[answer[1]] + " " + arr[answer[2]]);
    }


    public static void main(String[] args) throws Exception {
//        new BOJ2473().solution_bs();
        new BOJ2473().solution_tp();

    }
}
