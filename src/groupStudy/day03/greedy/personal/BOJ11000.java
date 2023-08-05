package groupStudy.day03.greedy.personal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 강의실 배정
 */
public class BOJ11000 {

    static int N;
    static int numOfClassRoom = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        ArrayList<Class> classes = new ArrayList<>();

        while (N-- > 0) {
            String[] s = bufferedReader.readLine().split(" ");
            int startTime = Integer.parseInt(s[0]);
            int endTime = Integer.parseInt(s[1]);

            classes.add(new Class(startTime, endTime));
        }

        Collections.sort(classes, (classA, claasB) -> classA.startTime - claasB.startTime);

        numOfClassRoom = findNumberOfNeededClassRooms(classes);

        System.out.println(numOfClassRoom);
    }

    private static int findNumberOfNeededClassRooms(ArrayList<Class> classes) {
        PriorityQueue<Integer> endTimeFirstHeap = new PriorityQueue<>();
        int classRoomCnt = 1;
        endTimeFirstHeap.add(classes.get(0).endTime);

        for (int i = 1; i < classes.size(); i++) {

            Integer endTime = endTimeFirstHeap.peek();
            Class curClass = classes.get(i);

            if (endTime <= curClass.startTime) {
                endTimeFirstHeap.poll();
                endTimeFirstHeap.add(curClass.endTime);
            } else {
                endTimeFirstHeap.add(curClass.endTime);
                classRoomCnt++;
            }
        }

        return classRoomCnt;
    }

    private static class Class{

        int startTime;
        int endTime;

        public Class(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

}
