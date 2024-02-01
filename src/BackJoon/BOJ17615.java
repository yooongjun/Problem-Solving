    package BackJoon;

    import java.io.BufferedReader;
    import java.util.Scanner;

    public class BOJ17615 {

        static int N;
        static String balls;

        static int min = 500000;

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            N = Integer.parseInt(scanner.nextLine());
            balls = scanner.nextLine();

            move('B', 0);
            move('B', 1);
            move('R', 0);
            move('R', 1);

            System.out.println(min);
        }

        static void move(char color, int direction) {
            int count = 0;
            boolean needJump = false;

            // 왼쪽으로 모으기
            if (direction == 0) {
                for (int i = 0; i < balls.length(); i++) {
                    char ball = balls.charAt(i);

                    if (ball != color) {
                        needJump = true;
                    }
                    else if(needJump){
                        count++;
                    }

                    if (count >= min) {
                        return;
                    }

                }
            }
            else{
                for (int i = balls.length() -1; i >= 0; i--){
                    char ball = balls.charAt(i);

                    if (ball != color) {
                        needJump = true;
                    }
                    else if(needJump){
                        count++;
                    }

                    if (count >= min) {
                        return;
                    }
                }
            }

            min = Math.min(count, min);
        }




    }
