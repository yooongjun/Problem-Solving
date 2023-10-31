package groupStudy.day13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;

public class BOJ1406 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String defaultString = bufferedReader.readLine();
        int numOfCommands = Integer.parseInt(bufferedReader.readLine());

        LinkedList<Character> editor = new LinkedList<>();

        for (int i = 0 ; i < defaultString.length(); i++) {
            editor.add(defaultString.charAt(i));
        }

        ListIterator<Character> cursor = editor.listIterator();

        // 커서 맨 뒤에 위치시키기
        while (cursor.hasNext()) {
            cursor.next();
        }

        while(numOfCommands-- > 0){
            String commandInput = bufferedReader.readLine();

            switch (commandInput.charAt(0)) {
                case 'L':
                    if(cursor.hasPrevious())
                        cursor.previous();
                    break;

                case 'D':
                    if(cursor.hasNext())
                        cursor.next();
                    break;

                case 'B':
                    if (cursor.hasPrevious()) {
                        cursor.previous();
                        cursor.remove();
                    }
                    break;
                case 'P':
                    cursor.add(commandInput.charAt(2));
                    break;

                default:
                    break;
            }
        }

        for(Character c : editor) {
            bufferedWriter.append(c);
        }

        bufferedWriter.flush();
    }


}

