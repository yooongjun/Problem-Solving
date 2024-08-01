package BackJoon;

import java.util.*;
import java.io.*;

public class BOJ1780{

    static int n;
    static int[][] map;
    static int[] answers = new int[3];

    static boolean isCountable(int x, int y, int size){
        int type = map[x][y];

        for(int i = x; i < x + size; i++){
            for(int j = y; j < y + size; j++){
                if(map[i][j] != type){
                    return false;
                }
            }
        }
        answers[type + 1]++;
        return true;
    }


    public static void findNum(int size, int x, int y) {

        if(isCountable(x, y, size)){
            return;
        }



        int nextSize = size / 3;

        for(int i = x; i < x + size; i += nextSize){
            for(int j = y; j < y + size; j+= nextSize){
                findNum(nextSize, i, j);
            }
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];

        for (int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        findNum(n, 0, 0);


        System.out.println(answers[0] + "\n" + answers[1] + "\n" + answers[2]);
    }

}