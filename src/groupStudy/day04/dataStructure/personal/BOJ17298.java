package groupStudy.day04.dataStructure.personal;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;

/**
 * 오큰수
 */
public class BOJ17298 {

    static int N;

    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bufferedReader.readLine());
        Stack<Element> stack = new Stack<>();
        
        A = new int[N];
        int NGE[] = new int[N];

        String s[] = bufferedReader.readLine().split(" ");

        // NGE 초기화
        Arrays.fill(NGE, -1);

        for (int i = 0; i < s.length; i++) {

            Element element = new Element(i, Integer.parseInt(s[i]));

            if ( !stack.isEmpty() &&  ( stack.peek().value < element.value ) ) {

                while (!stack.isEmpty()) {

                    if(stack.peek().value >= element.value) break;

                    Element pop = stack.pop();
                    NGE[pop.index] = element.value;
                }
            }

            stack.add(element);
        }

        Arrays.stream(NGE).forEach( e -> {
            try {
                bufferedWriter.append(e + " ");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedWriter.flush();
    }

    private static class Element{

        int index;
        int value;

        public Element(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

}
