package groupStudy.day04.dataStructure.group;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Binary tree
 */
public class BOJ13237 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bufferedReader.readLine());

        int depth[] = new int[N + 1];
        Queue<Node> queue = new LinkedList<>();

        Arrays.fill(depth, -1);

        for (int i = 1; i <= N; i++) {

            int parentNode = Integer.parseInt(bufferedReader.readLine());

            if (parentNode == -1) {
                depth[i] = 0;
                continue;
            }

            queue.add(new Node(i, parentNode));
        }

        while (!queue.isEmpty()) {

            Node child = queue.poll();

            if (depth[child.parent] == -1) {
                queue.add(child);
                continue;
            }

            depth[child.node] = depth[child.parent] + 1;
        }

        for (int i = 1; i < depth.length; i++) {
            System.out.println(depth[i]);
        }
    }

    static class Node{
        int node;
        int parent;

        public Node(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }

}
