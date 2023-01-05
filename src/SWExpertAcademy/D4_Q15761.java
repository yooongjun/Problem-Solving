package SWExpertAcademy;

import java.util.Scanner;

// 크고 작은 이진수의 곱셈
public class D4_Q15761 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 1; i <= T; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int num = 0;
            if (A == B) {

                num = A == 1 ? 1: A + B;

            } else if (A > B) {
                if( B == 1)
                    num = A==2 ? 4 : A+B;
                else
                    num = A;

            } else {

                num = A == 1 ?   1  :  2 * A ;

            }

            System.out.println("#"+ i +" "+num);

        }
    }



}
