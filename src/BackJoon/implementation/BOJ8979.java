package BackJoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 올림픽
 */
public class BOJ8979 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        List<Country> countryList = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String[] input = br.readLine().split(" ");
            int a,b,c,d;
            a = Integer.parseInt(input[0]);
            b = Integer.parseInt(input[1]);
            c = Integer.parseInt(input[2]);
            d = Integer.parseInt(input[3]);
            countryList.add(new Country(a,b, c, d));
        }

        Collections.sort(countryList);

        int score = 1;
        Country oldCountry = countryList.get(0);

        for (int i = 0; i < countryList.size(); i++) {

            Country now = countryList.get(i);

            if (now.compareTo(oldCountry) != -1) {
                score = i + 1;
            }

            if (now.num == k) {
                break;
            }

            oldCountry = now;
        }

        System.out.println(score);

    }


    static class Country implements Comparable<Country>{

        int num,gold, silver, bronze;

        public Country(int num, int gold, int silver, int bronze) {
            this.num = num;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        public void printCountry() {
            System.out.println(this.num + "," + this.gold + "," + this.silver + "," + this.bronze);
        }

        @Override
        public int compareTo(Country o) {
            if (this.gold != o.gold) {
                return Integer.compare(o.gold, this.gold); // gold 메달 수를 내림차순으로 정렬
            } else if (this.silver != o.silver) {
                return Integer.compare(o.silver, this.silver); // silver 메달 수를 내림차순으로 정렬
            } else if (this.bronze != o.bronze) {
                return Integer.compare(o.bronze, this.bronze); // bronze 메달 수를 내림차순으로 정렬
            }

            return -1;
        }
    }
}
