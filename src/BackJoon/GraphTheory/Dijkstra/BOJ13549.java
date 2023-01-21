package BackJoon.GraphTheory.Dijkstra;

import java.util.PriorityQueue;
import java.util.Scanner;

// 숨바꼭질 3
public class BOJ13549 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int result = 0;

        if (N > K) {
            System.out.println(N - K);
            return;
        }

        int mx[] = {2, -1, 1};

        boolean[] visit = new boolean[1000001];
        PriorityQueue<Node> pq = new PriorityQueue<>( (n1, n2) -> n1.time - n2.time);
        pq.add(new Node(N, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.x == K) {
                result = cur.time;
                break;
            }

            if (visit[cur.x]) {
                continue;
            }

            visit[cur.x] = true;

            for (int i = 0; i < 3; i++) {
                int xx = ( (i == 0) ? ( mx[i] * cur.x ) : ( mx[i] + cur.x ));

                if (xx >= 0 && xx < visit.length && !visit[xx]) {

                    if (i == 0)
                        pq.add(new Node(xx, cur.time));
                    else
                        pq.add(new Node(xx, cur.time + 1));
                }
            }
        }
        System.out.println(result);
    }

    static class Node{

        int x;

        int time;

        public Node(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }


}
