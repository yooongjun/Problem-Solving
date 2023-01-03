package BackJoon.GraphTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 최단경로
public class BOJ1753 {

    // 각 노드까지의 최단거리
    static int[] value;

    static boolean[] checked;

    static List<NODE> nodes[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine());

        nodes = new ArrayList[V+1];
        value = new int[V+1];
        checked = new boolean[V+1];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                int  u= Integer.parseInt(st.nextToken());
                int  v= Integer.parseInt(st.nextToken());
                int  w= Integer.parseInt(st.nextToken());

                if (nodes[u] == null)
                    nodes[u] = new ArrayList<>();

                nodes[u].add(new NODE(v, w));
            }
        }

        PriorityQueue<NODE> queue = new PriorityQueue<>();
        if (nodes[start] == null) {
            for (int i = 0; i < V; i++) {
                stringBuilder.append("INF\n");
            }
            System.out.println(stringBuilder);
            return;
        }

        value[start] = 0;
        checked[start] = true;

        for (NODE node : nodes[start]) {

            if (value[node.v] < value[start] + node.w && checked[node.v])
                continue;

            node.distance = value[start] + node.w;
            value[node.v] = node.w;
            checked[node.v] = true;
            queue.add(node);
        }

        while (!queue.isEmpty()) {
            NODE cur = queue.poll();
            int curNodeNum = cur.v;

            if (nodes[curNodeNum] == null || cur.distance > value[curNodeNum] ){
                continue;
            }

            for (NODE node : nodes[curNodeNum]) {

                if (value[node.v] < value[curNodeNum] + node.w && checked[node.v])
                    continue;

                node.distance = value[curNodeNum] + node.w;
                value[node.v] = value[curNodeNum] + node.w;
                checked[node.v] = true;
                queue.add(node);
            }
        }

        for (int i = 1; i <= V; i++) {
            if (!checked[i]) {
                stringBuilder.append("INF\n");
                continue;
            }
            stringBuilder.append(value[i] + "\n");
        }
        System.out.println(stringBuilder);





    }

    static class NODE implements Comparable<NODE> {

        int distance;
        int v;
        int w;

        NODE ( int v, int w){
            this.v = v;
            this.w = w;
        }


        @Override
        public int compareTo(NODE o) {

            if ( this.distance > o.distance )
                return 1;

            else if ( this.distance == o.distance )
                return 0;

            else
                return -1;

        }
    }


}

