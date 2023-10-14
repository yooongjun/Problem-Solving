package silverRandomDefence;

import java.util.Scanner;

public class BOJ1913 {

    static int map[][];
    static int n;
    static int findX,findY;
    static int value;
    static int x = 0,y = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();

        n = scanner.nextInt();
        value = n * n;
        map = new int[n][n];

        makeSnail(scanner.nextInt());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                stringBuilder.append(map[i][j] + " ");
            }
            stringBuilder.append("\n");
        }

        System.out.print(stringBuilder);
        System.out.println((findX + 1) + " " + (findY + 1));
    }

    static void makeSnail(int findNum) {

        while (value > 0) {
            down();
            y++;
            if(value == 0)
                break;

            right();
            x--;
            up();
            y--;
            left();
            x++;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == findNum) {
                    findX = i;
                    findY = j;
                }
            }
        }

    }

    static void down() {
        for (int i = x; i < n; i++) {
            if (map[i][y] == 0) {
                map[i][y] = value--;
            } else {
                x = i -1;
                return;
            }
        }
        x = n - 1;
    }

    static void up() {
        for (int i = x; i >= 0; i--) {
            if (map[i][y] == 0) {
                map[i][y] = value--;
            } else {
                x = i + 1;
                return;
            }
        }
        x = 0;
    }

    static void right() {
        for (int i = y; i < n; i++) {
            if (map[x][i] == 0) {
                map[x][i] = value--;
            } else{
                y = i - 1;
                return;
            }
        }
        y = n -1;
    }

    static void left() {
        for (int i = y; i >= 0; i--) {
            if (map[x][i] == 0) {
                map[x][i] = value--;
            } else {
                y = i + 1;
                return;
            }
        }
        y = 0;
    }



}
