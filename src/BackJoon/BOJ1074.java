package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Z
 */
public class BOJ1074 {

    static int pow[];
    static int count = 0;
    static int r, c;

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        r = Integer.parseInt(s[1]);
        c = Integer.parseInt(s[2]);

        pow = new int[N + 1];
        pow[0] = 1;

        for (int i = 1; i <= N; i++) {
            pow[i] = 2 * pow[i - 1];
        }

        divide(0, 0, N);

        System.out.println(answer);
    }

    static void divide(int x, int y, int n){

        if (n == 0) {

            if(x == r && y == c){
                answer = count;
            }

            count++;
            return;
        }

        int xx = x + pow[n - 1];
        int yy = y + pow[n - 1];
        int size = pow[n-1] * pow[n-1];

        if (r < xx && c < yy) {
            divide(x, y, n - 1);
        }
        else if(r < xx && c >= yy )
        {
            count += size;
            divide(x, yy, n - 1);
        } else if (r >= xx && c < yy) {
            count += (2 * size);
            divide(xx, y, n - 1);
        } else {
            count += (3 * size);
            divide(x + pow[n - 1], y + pow[n - 1], n - 1);
        }
    }

}