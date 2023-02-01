package SDS.day03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 괄호의 값
public class BOJ2504 {
    static char[] arr;

    // (, ), [, ]
    static int[] param = {-1,-2,-3,-4};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = br.readLine().toCharArray();

        System.out.println(func());

    }

    static int func() {

        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int openA=0;
        int openB=0;
        int tmp = 0;
        int c = 0;
        // 괄호를 여는 경우 스택에 추가, 닫는 괄호는 여는 괄호가 나올 때까지 스택에서 꺼냄
        for(int i=0; i <arr.length; i++) {

            if( ( arr[i] == '(' ) )
            {
                openA++;
                stack.add(param[0]);
                continue;
            }

            if(arr[i] == '[') {
                openB++;
                stack.add(param[2]);
                continue;
            }

            if(arr[i] == ')')
            {
                tmp = 0;
                c = 0;
                openA--;

                while(!stack.isEmpty()) {
                    c = stack.pop();

                    if(c == param[0])
                        break;

                    if(c == param[2])
                        return 0;

                    else {
                        tmp += c;
                    }
                }

                if(c != param[0])
                    return 0;

                tmp = tmp * 2;

                if(tmp == 0)
                    stack.add(2);
                else
                    stack.add(tmp );

                continue;
            }

            if(arr[i] == ']')
            {
                tmp = 0;
                c = 0;
                openB--;

                while(!stack.isEmpty()) {
                    c = stack.pop();

                    if(c==param[2])
                        break;


                    if(c == param[0])
                        return 0;
                    else {
                        tmp += c;
                    }
                }

                if(c != param[2])
                    return 0;

                tmp  = tmp * 3;

                if(tmp == 0)
                    stack.add(3);
                else
                    stack.add(tmp);

                continue;
            }



        }

        if(openA != 0 || openB != 0)
            return 0;

        while(!stack.isEmpty())
            result += stack.pop();

        return result;
    }

}
