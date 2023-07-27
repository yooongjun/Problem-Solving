package groupStudy.day01.implementation.personal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 후보 추천하기
 */
public class BOJ1713 {
    static int t = 0;
    static PriorityQueue<Node> priorityQueue;
    static boolean[] onPhotoList;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        priorityQueue = new PriorityQueue<>((n1, n2) ->
                ((n1.suggestionCnt - n2.suggestionCnt) == 0) ? (n2.turn - n1.turn) : (n1.suggestionCnt - n2.suggestionCnt));
        List<Integer> result = new ArrayList<>();

        // input
        int N = Integer.parseInt(bufferedReader.readLine());
        int totalCnt = Integer.parseInt(bufferedReader.readLine());
        onPhotoList= new boolean[101];
        String[] s = bufferedReader.readLine().split(" ");

        for (int i = 0; i < totalCnt; i++) {
            int student = Integer.parseInt(s[i]);
            Stack<Node> temp = new Stack<>();

            // 사진틀에 게시된 경우 확인
            if (onPhotoList[student]) {
                while (!priorityQueue.isEmpty()) {
                    Node node = priorityQueue.poll();
                    temp.add(node);

                    if (node.studentNum == student) {
                        node.suggestionCnt++;
                        break;
                    }
                }

                for (Node n : temp) priorityQueue.add(n);
            }
            else {
                // 사진틀에 자리가 남아있는 경우
                if (priorityQueue.size() < N) {
                    addNewStudent(student);
                }
                else // if 자리가 없는 경우
                {
                    int min = priorityQueue.peek().suggestionCnt;

                    // 가장 오래된 학생을 내림
                    while (!priorityQueue.isEmpty()) {

                        Node next = priorityQueue.poll();

                        if (priorityQueue.isEmpty() || min < priorityQueue.peek().suggestionCnt) {
                            onPhotoList[next.studentNum] = false;
                            break;
                        }

                        temp.add(next);
                    }

                    for (Node n : temp) priorityQueue.add(n);
                    addNewStudent(student);
                }
            }
        }

        while (!priorityQueue.isEmpty()){
            result.add(priorityQueue.poll().studentNum);
        }

        Collections.sort(result);

        result.forEach(n -> System.out.print(n + " "));
    }

    private static void addNewStudent(int student) {
        priorityQueue.add(new Node(student, 1));
        onPhotoList[student] = true;
    }

    static class Node{

        int studentNum;
        int suggestionCnt;

        int turn = t++;

        public Node(int studentNum, int suggestionCnt) {
            this.studentNum = studentNum;
            this.suggestionCnt = suggestionCnt;
        }
    }


}
