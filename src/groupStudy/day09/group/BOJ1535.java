package groupStudy.day09.group;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 안녕
public class BOJ1535 {

    static int n;
    static Person[] people;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());
        people = new Person[n];

        String[] input_1 = bufferedReader.readLine().split(" ");
        String[] input_2 = bufferedReader.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            int price = Integer.parseInt(input_1[i]);
            int value = Integer.parseInt(input_2[i]);
            people[i] = new Person(price, value);
        }

        // 내림차순 정렬
        Arrays.sort(people, (p1, p2) -> p1.price - p2.price);





    }

    static class Person{

        int price;
        int value;

        public Person(int price, int value) {
            this.price = price;
            this.value = value;
        }
    }



}
