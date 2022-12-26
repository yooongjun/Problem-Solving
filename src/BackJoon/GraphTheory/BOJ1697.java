package BackJoon.GraphTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1697 {

    static int N , K;

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer( br.readLine() );
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(N == K)
            min = 0;
        else
            BFS();

        System.out.println(min);
    }

    static void BFS(){
        int arr[] = new int[1000001];
        boolean checked[] = new boolean[1000001];
        arr[K] = -1; // 목표 지점

        checked[N] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);

        while (!queue.isEmpty()) {
            Integer idx = queue.poll();

            if( idx == K )
                break;

            if ( idx + 1 <= K && !checked[idx + 1] ){
                queue.add(idx + 1);
                arr[idx + 1] = arr[idx] + 1;
                checked[idx + 1 ] = true;
            }
            if ( idx * 2 < arr.length && !checked[idx*2] && idx < K) {
                queue.add(idx * 2);
                arr[idx * 2] = arr[idx] + 1;
                checked[idx * 2] = true;
            }
            if ( idx - 1 >= 0 && !checked[idx-1]) {
                queue.add(idx - 1);
                arr[idx - 1] = arr[idx] + 1;
                checked[idx - 1] = true;
            }
        }

        min = arr[K];
        return;
    }






    static void DFS(int current, int cnt){

        if ( cnt >= min || current < 0 || current > 100000)
            return;

        if (current == K) {
            min = Math.min(min, cnt);
            return;
        }

            if(current < K)
            {
                if( 2 * current <= K)
                    DFS(current * 2 , cnt + 1);
                else {
                    DFS(current * 2, cnt + 1);
                    DFS(current + 1, cnt + 1);
                    DFS(current - 1, cnt + 1);
                }
            }
            else {
                DFS(current - 1, cnt + 1);
            }
    }

}
