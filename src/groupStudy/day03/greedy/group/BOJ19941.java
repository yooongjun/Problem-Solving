package groupStudy.day03.greedy.group;

import java.awt.geom.RectangularShape;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ19941 {

    static int N;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        int max = findMax(bufferedReader.readLine());

        System.out.println(max);
    }

    private static int findMax(String s) {
        ArrayList<Integer> people = new ArrayList<>();
        Queue<Integer> burgers = new LinkedList<>();
        int result = 0;

        insertPersonBurger(s, people, burgers);

        for (int i = 0; i < people.size(); i++) {
            Integer person = people.get(i);

            if(canEatBurger(person, burgers)) result++;
        }

        return result;
    }

    private static boolean canEatBurger(Integer person, Queue<Integer> burgers) {

        while (!burgers.isEmpty()) {

            Integer burger = burgers.peek();

            int distance = findDistance(person, burger);

            if ( person > burger) {

                burgers.poll();

                if ( distance <= K) return true;
            }

            if( burger > person) {

                if ( distance <= K) {
                    burgers.poll();
                    return true;
                }

                break;
            }
        }

        return false;
    }

    private static int findDistance(int A, int B) {
        return A > B ? (A - B) : (B - A);
    }


    private static void insertPersonBurger(String s, ArrayList<Integer> peopleIndex, Queue<Integer> burgerIndex) {
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == 'H') burgerIndex.add(i + 1);

            else peopleIndex.add(i + 1);

        }
    }

}
