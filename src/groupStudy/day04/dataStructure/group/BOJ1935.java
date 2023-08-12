package groupStudy.day04.dataStructure.group;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 후위 표기식 2
 */
public class BOJ1935 {

    static int N;
    static char alphabet = 'A';
    static HashMap<Character, Integer> operands = new HashMap<>();
    static Stack<Double> stack = new Stack<>();
    static List<Character> operators = new ArrayList<>(Arrays.asList('+','-','*','/'));

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bufferedReader.readLine());

        String expression = bufferedReader.readLine();

        while (N-- > 0) {
            int value = Integer.parseInt(bufferedReader.readLine());
            operands.put(alphabet, value);
            alphabet += 1;
        }

        double result = operate(expression);

        System.out.printf("%.2f", result);
    }

    private static double operate(String experssion) {

        for (int i = 0; i < experssion.length(); i++) {
            char c = experssion.charAt(i);

            if (!operators.contains(c)) {
                stack.add((double)operands.get(c));
                continue;
            }

            double right = stack.pop();
            double left = stack.pop();

            stack.add(calculate(left, right, c));
        }

        return stack.pop();
    }

    private static double calculate(double op1, double op2, char operator) {

        double result = 0;

        switch (operator) {

            case '+':
                result = op1 + op2;
                break;

            case '-':
                result = op1 - op2;
                break;

            case '*':
                result = op1 * op2;
                break;

            case '/':
                result = op1 / op2;
                break;
        }

        return result;
    }





}
