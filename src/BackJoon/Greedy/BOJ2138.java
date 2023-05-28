package BackJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 전구와 스위치
 */
public class BOJ2138 {

    static int n;
    static int min = Integer.MAX_VALUE;
    static char[] target;
    static char[] input;
    static char[] state;

    static char[] original;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        input = br.readLine().toCharArray();
        target = br.readLine().toCharArray();

        // 0번째를 바꿨다고 가정한 배열
        state = Arrays.copyOf(input, 3);
        changeState(state, 0);

        original = Arrays.copyOf(input, 3);

        back(state, 1, 1);
        back(original, 1, 0);

        System.out.println( (min == Integer.MAX_VALUE ) ? -1 : min);
    }

    static void back(char[] now, int idx, int cnt) {

        if(cnt >= min || idx > n) return;

        if (idx == n) {
            if(target[n-1] == now[0]){
                min = Math.min(cnt, min);
            }
            return;
        }

        char[] arr = now.clone();
        changeState(arr, idx);

        if (target[idx - 1] == arr[0]) {
            copyArr(idx, arr);
            back(arr, idx + 1, cnt + 1);
        } else {
            copyArr(idx, now);
            back(now, idx + 1, cnt);
        }

    }

    private static void copyArr(int idx, char[] arr) {
        arr[0] = arr[1];
        arr[1] = arr[2];

        if (idx <= n - 3) {
            arr[2] = input[idx+2];
        }
        else arr[2] = '2';
    }

    static void changeState(char[] arr, int idx){

        if (idx == 0) {
            arr[0] = (arr[0] == '0') ? '1' : '0';
            arr[1] = (arr[1] == '0') ? '1' : '0';
        } else if (idx == n - 1) {
            arr[0] = (arr[0] == '0') ? '1' : '0';
            arr[1] = (arr[1] == '0') ? '1' : '0';
        } else {
            arr[0] = (arr[0] == '0') ? '1' : '0';
            arr[1] = (arr[1] == '0') ? '1' : '0';
            arr[2] = (arr[2] == '0') ? '1' : '0';
        }
    }

}
