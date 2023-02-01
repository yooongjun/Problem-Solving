package SDS.day03;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

// 최대 힙
public class BOJ11279 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
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
