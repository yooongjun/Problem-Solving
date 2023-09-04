package groupStudy.day07.personal;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 숨바꼭질2
 */
public class BOJ12851 {

    static int minTime = Integer.MAX_VALUE;
    static int numOfFastestPath;
    static int destination; // k
    static int start; // n

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        start = scanner.nextInt();
        destination = scanner.nextInt();

        findMinTime(start, destination);

        System.out.println(minTime);
        System.out.println(numOfFastestPath);
    }

    public static void findMinTime(int start, int destination) {
        int visit[] = new int[100001];
        visit[destination] = 100001;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start, 0));

        if (start == destination) {
            minTime = 0;
            numOfFastestPath = 1;
            return;
        }

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            for (int i = 1; i <= 3; i++) {

                int position = move(i, cur.x);

                if(position < 0 || position > 100000 || ( visit[position] != 0 && visit[position] < cur.cnt + 1 ) ) continue;

                if (position == destination) {

                    if (visit[position] == cur.cnt + 1) {
                        numOfFastestPath++;
                    }

                    if (visit[position] > cur.cnt + 1) {
                        numOfFastestPath = 1;
                        visit[position] = minTime = cur.cnt + 1;
                    }

                    continue;
                }

                if(cur.cnt + 1 > minTime) continue;

                visit[position] = cur.cnt + 1;
                queue.add(new Node(position, cur.cnt + 1));
            }
        }
    }


    static int move(int n,int x) {
        switch (n) {
            case 1:
                return x - 1;
            case 2:
                return x + 1;
            default:
                return x * 2;
        }
    }

    static private class Node{
        int x;
        int cnt;

        public Node(int x, int cnt) {
            this.x = x;
            this.cnt = cnt;
        }
    }

}
