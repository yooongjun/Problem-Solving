package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 트리 순회
public class BOJ1991 {

    static int n;
    static char[][] tree = new char[27][2];
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {
            String s = bufferedReader.readLine();

            char parent = s.charAt(0);
            char left = s.charAt(2);
            char right = s.charAt(4);

            tree[parent-'A'][0] = left;
            tree[parent - 'A'][1] = right;
        }

        preOrder('A');
        stringBuilder.append("\n");
        inOrder('A');
        stringBuilder.append("\n");
        postOrder('A');

        System.out.println(stringBuilder.toString());
    }

    static void inOrder(char node) {

        int idx = node - 'A';

        if (tree[idx][0] != '.') {
            inOrder(tree[idx][0]);
        }

        stringBuilder.append(node);

        if (tree[idx][1] != '.') {
            inOrder(tree[idx][1]);
        }

    }

    static void postOrder(char node) {
        int idx = node - 'A';

        if (tree[idx][0] != '.') {
            postOrder(tree[idx][0]);
        }

        if (tree[idx][1] != '.') {
            postOrder(tree[idx][1]);
        }

        stringBuilder.append(node);
    }

    static void preOrder(char node) {
        stringBuilder.append(node);

        int idx = node - 'A';

        if (tree[idx][0] != '.') {
            preOrder(tree[idx][0]);
        }
        if (tree[idx][1] != '.') {
            preOrder(tree[idx][1]);
        }

    }

}
