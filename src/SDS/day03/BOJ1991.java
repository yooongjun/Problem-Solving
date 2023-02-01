package SDS.day03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 트리 순회
public class BOJ1991 {

    static int child[][] = new int[27][3];
    static boolean visit[];


    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++ )
        {
            String s = br.readLine().replace(" ", "");

            if(s.charAt(1) != '.')
                child[s.charAt(0) - 'A' + 1][1] = s.charAt(1) - 'A' + 1;

            if(s.charAt(2) != '.')
                child[s.charAt(0) - 'A' + 1][2] = s.charAt(2) - 'A' + 1;
        }

        visit = new boolean[100];

        preOrder(1);
        System.out.println();
        inOrder(1);
        System.out.println();
        postOrder(1);
    }



    static void preOrder(int node){
        if(node == 0) return;
        System.out.printf("%c", node + 'A' -1 );
        preOrder(child[node][1]);
        preOrder(child[node][2]);
    }

    static void inOrder(int node){
        if(node == 0) return;
        inOrder(child[node][1]);
        System.out.printf("%c", node + 'A' -1 );
        inOrder(child[node][2]);
    }

    static void postOrder(int node){
        if(node == 0) return;
        postOrder(child[node][1]);
        postOrder(child[node][2]);
        System.out.printf("%c", node + 'A' -1 );
    }
}
