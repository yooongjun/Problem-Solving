package groupStudy.day14;

import java.util.*;

// 요세푸스 문제
public class BOJ1158 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();

        int N = scanner.nextInt();
        int K = scanner.nextInt();

        List<Integer> order = new ArrayList<>();
        Node[] people = new Node[N + 1];

        // 인스턴스 생성
        for (int i = 1; i <= N; i++) {
            people[i] = new Node(i);
        }
        // 노드끼리 이어주기
        for (int i = 1; i <= N; i++) {
            people[i].next = people[i + 1 <= N ? i + 1 : 1];
            people[i].prev = people[i - 1 >= 1 ? i -1 : N];
        }


        Node person = people[1];
        int count = 1;
        int alive = N;

        while (true) {

            if(alive == 0){
                break;
            }

            if(count == K){
                // 제거하고 요세푸스 순열에 추가
                alive--;
                order.add(person.n);

                // 이전 사람과 다음 사람을 이어줌
                person.prev.next = person.next;
                person.next.prev = person.prev;

                // 다음 사람으로 변경
                person = person.next;

                // 순서 초기화
                count = 1;
                continue;
            }

            person = person.next;
            count++;
        }


        stringBuilder.append("<");
        for (int i = 0; i < order.size() - 1; i++) {
            stringBuilder.append(order.get(i) + ", ");
        }
        stringBuilder.append(order.get(order.size() - 1) + ">");

        System.out.println(stringBuilder);
    }

    static class Node{

        int n;
        Node next;
        Node prev;

        public Node(int n) {
            this.n = n;
        }
    }


}
