package SDS.day03;

import java.util.PriorityQueue;
import java.util.Scanner;

// 최소 힙
public class BOJ1927 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = sc.nextInt();

        for(int i= 0; i < n; i++) {
            int t = sc.nextInt();
            if(t != 0)
                pq.add(t);
            else if(pq.isEmpty())
                System.out.println(0);
            else
                System.out.println(pq.poll());
        }


    }

}
