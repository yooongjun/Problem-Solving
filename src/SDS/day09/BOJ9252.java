package SDS.day09;

import java.util.Scanner;

// LCS 2
public class BOJ9252 {

    static char s1[], s2[];
    static int dp[][];
    static int from[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String a = sc.nextLine();
        String b = sc.nextLine();

        dp = new int[a.length() +1][b.length()+ 1];
        from = new int[a.length() +1][b.length()+ 1];

        // 각각 [i-1][j-1 / [i-1][j] / [i][j-1]

        int equal = 0;
        int left = 1;
        int up= 2;

        for(int i = 1; i <= a.length(); i++) {
            for(int j =1; j <=b.length(); j++) {

                if(a.charAt(i -1) == b.charAt(j -1)) {
                    {
                        dp[i][j] = Math.max(dp[i-1][j], Math.max(dp[i][j-1] , dp[i-1][j-1] + 1));

                        // 같은 경우 대각선까지 고려함
                        if(dp[i][j-1] >= dp[i-1][j-1] +1) {
                            if(dp[i][j-1] >= dp[i-1][j]) {
                                from[i][j] = 1;
                            }
                        }
                        else if(dp[i-1][j-1] + 1 >= dp[i-1][j])
                        {
                            from[i][j] = 0;
                        }
                        else
                            from[i][j] = 2;
                    }
                }

                else
                {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);

                    if(dp[i][j - 1] >= dp[i - 1][j]) {
                        from[i][j] = 1;
                    }else
                        from[i][j] = 2;
                }
            }
        }

        // 트래킹
        int x = a.length();
        int y = b.length();

        StringBuilder sb = new StringBuilder();

        while(true) {

            if(x <= 0 || y <= 0)
                break;


            // 대각선에서 온 경우
            if(from[x][y] == 0) {
                sb.append(a.charAt(x - 1));
                x = x-1;
                y = y-1;
            }
            // 왼쪽에서 온 경우
            else if(from[x][y] == 1) {
                y= y-1;
            }
            else
                x = x-1;
        }


        System.out.println(dp[a.length()][b.length()]);
        if(sb.toString().length() != 0)
            System.out.println(sb.reverse());
    }



}
