package groupStudy.day06.group;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * DFS와 BFS
 */
public class BOJ1260 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n, m ,v;
        String[] s = bufferedReader.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        v = Integer.parseInt(s[2]);

        Node[] nodes = new Node[n + 1];

        // 노드 메모리 할당
        for (int i = 1; i < nodes.length; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 0; i < m; i++) {
            s = bufferedReader.readLine().split(" ");
            int n1, n2;
            n1 = Integer.parseInt(s[0]);
            n2 = Integer.parseInt(s[1]);

            // 간선 정보를 통해 두 정점에 이어지는 노드를 추가
            nodes[n1].next.add(n2);
            nodes[n2].next.add(n1);
        }

        // 정점 번호가 작은 것을 먼저 방문하기 위해 오름차순 정렬
        for (int i = 1; i < nodes.length; i++) {
            nodes[i].sortNext();
        }


        dfs(v,nodes);
        bfs(v, nodes);
    }

    private static void dfs(int startNode, Node[] nodes) {
        StringBuilder stringBuilder = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        boolean visit[] = new boolean[nodes.length];

        stack.add(startNode);

        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            Node node = nodes[pop];

            if(visit[node.n]) continue;

            visit[node.n] = true;
            stringBuilder.append(pop + " ");

            for (int i = node.next.size() - 1; i >= 0; i--) {
                if (!visit[node.next.get(i)]) {
                    stack.add(node.next.get(i));
                }
            }
        }

        System.out.println(stringBuilder);
    }

    private static void bfs(int startNode, Node[] nodes) {
        StringBuilder stringBuilder = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        boolean visit[] = new boolean[nodes.length];

        queue.add(startNode);
        visit[startNode] = true;

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            Node node = nodes[poll];

            stringBuilder.append(poll + " ");

            for (int i = 0; i < node.next.size(); i++) {
                if (!visit[node.next.get(i)]) {
                    visit[node.next.get(i)] = true;
                    queue.add(node.next.get(i));
                }
            }
        }
        System.out.println(stringBuilder);
    }


    private static class Node {

        int n;
        ArrayList<Integer> next = new ArrayList<>();

        public void sortNext() {
            Collections.sort(next);
        }

        public Node(int n) {
            this.n = n;
        }
    }


}
