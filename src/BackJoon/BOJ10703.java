package BackJoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 유성
public class BOJ10703 {

    static int R, S;
    static char[][] photo;
    static char[][] result;
    static int[] bottom_meteor;
    static int[] top_ground;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        photo = new char[R][S];
        result = new char[R][S];
        bottom_meteor = new int[S];
        top_ground = new int[S];

        Arrays.fill(bottom_meteor, -1);
        Arrays.fill(top_ground, -1);

        for (int i = 0; i < R; i++) {
            String s = br.readLine();

            for (int j = 0; j < S; j++) {
                photo[i][j] = s.charAt(j);
                result[i][j] = photo[i][j] != 'X' ? photo[i][j] : '.';

                if (photo[i][j] == 'X') {
                    bottom_meteor[j] = i;
                }

                if (photo[i][j] == '#' && top_ground[j] == -1) {
                    top_ground[j] = i;
                }

            }
        }


        int min = 3000;

        for (int i = 0; i < S; i++) {
            if (bottom_meteor[i] != -1) {
                min = Math.min(top_ground[i] - bottom_meteor[i] - 1, min);
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < S; j++) {
                if(photo[i][j] == 'X'){
                result[i + min][j] = photo[i][j];
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < S; j++) {
                bw.append(result[i][j]);
            }
            bw.append("\n");
        }


        bw.flush();
        bw.close();
        br.close();



    }


    public static void main(String[] args) throws IOException {
        new BOJ10703().solution();
    }

}
