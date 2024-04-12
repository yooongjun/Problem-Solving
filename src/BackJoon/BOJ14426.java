package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

// 접두사 찾기
public class BOJ14426 {

    static int N, M;
    static Node trie = new Node(); // trie의 루트 노드

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bufferedReader.readLine().split(" ");

        int cnt = 0;
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        for (int i = 0; i < N; i++) {
            insertNode(bufferedReader.readLine());
        }

        for (int i = 0; i < M; i++) {
            if (searchNode(bufferedReader.readLine())) {
               cnt++;
            }
        }

        System.out.println(cnt);
    }

    static boolean searchNode(String s) {

        Node node = trie;

        for (int i = 0; i < s.length(); i++) {
            if (node.child.containsKey(s.charAt(i))) {
                node = node.child.get(s.charAt(i));
            } else {
                return false;
            }
        }
        return true;
    }

    static void insertNode(String s) {

        Node node = trie;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            node = node.child.computeIfAbsent(c, k -> new Node());
        }
    }

    static class Node{
        HashMap<Character, Node> child = new HashMap<>();
    }
}
