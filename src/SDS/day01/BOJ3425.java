package SDS.day01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

// 고스택
public class BOJ3425 {

    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> commands;

        while(true) {
            String s = br.readLine();

            if(String.valueOf(s).equals("QUIT"))
                return;

            else {
                commands = new ArrayList<String>();
                String inputCommand = s;

                GoStack goStack = new GoStack();

                // 명령어 입력
                while(!String.valueOf(inputCommand).equals("END")) {

                    commands.add(inputCommand);
                    inputCommand = br.readLine();
                }

                goStack.commands = commands;

                int n = Integer.parseInt(br.readLine());

                for(int i=0; i <n; i++) {
                    goStack.inputNum = Integer.parseInt(br.readLine());

                    if(!goStack.progress())
                        System.out.println("ERROR");
                    else
                        System.out.println(goStack.POP());

                    // 커멘드와 num_X 제외하고 초기화
                    goStack.afterProgress();
                }
                br.readLine();
            }
            System.out.println();
        }







    }


    static class GoStack{

        GoStack(){
        }

        ArrayList<String> commands;

        Stack<Integer> stack = new Stack<>();

        // 시작 스택 값
        int inputNum, NUM_X;

        boolean isError = false;

        void afterProgress() {
            this.stack.clear();
            this.isError = false;
        }

        boolean progress() {
            this.stack.add(inputNum);

            for (String command : commands) {

                int tmp = -1;

                if(command.contains(" ")) {
                    this.NUM_X =Integer.parseInt(command.split(" ")[1]);
                    command = command.split(" ")[0];
                }

                switch (command) {

                    case "NUM":
                        this.NUM();
                        break;
                    case "POP":
                        if (this.stack.size() == 0) {
                            this.isError = true;
                            break;
                        }
                        this.POP();
                        break;
                    case "INV":
                        if (this.stack.size() == 0) {
                            this.isError = true;
                            break;
                        }
                        this.INV();
                        break;
                    case "DUP":
                        if (this.stack.size() == 0) {
                            this.isError = true;
                            break;
                        }
                        this.DUP();
                        break;
                    case "SWP":
                        if (this.sizeError()) break;
                        this.SWP();
                        break;
                    case "ADD":
                        if (this.sizeError()) break;
                        tmp = this.ADD();
                        if (this.isError || Math.abs(tmp) > Math.pow(10, 9)) {
                            return false;
                        }
                        this.stack.add(tmp);
                        break;
                    case "SUB":
                        if (this.sizeError()) break;
                        tmp = this.SUB();
                        if (this.isError || Math.abs(tmp) > Math.pow(10, 9)) {
                            return false;
                        }
                        this.stack.add(tmp);

                        break;
                    case "MUL":
                        if (this.sizeError()) break;
                        long value = this.MUL();
                        if (this.isError || Math.abs(value) > Math.pow(10, 9)) {
                            return false;
                        }
                        this.stack.add((int)value);

                        break;
                    case "DIV":
                        if (this.sizeError()) break;
                        tmp = this.DIV();
                        if (this.isError || Math.abs(tmp) > Math.pow(10, 9)) {
                            return false;
                        }
                        this.stack.add(tmp);

                        break;
                    case "MOD":
                        if (this.sizeError()) break;
                        tmp = this.MOD();
                        if (this.isError || tmp > Math.pow(10, 9)) {
                            return false;
                        }
                        this.stack.add(tmp);
                        break;
                    default:
                        this.isError = true;
                }

                if(this.isError)
                    return false;

            }

            return stack.size() == 1;
        }


        void NUM() {
            stack.add(NUM_X);
        }

        int POP() {return stack.pop();}

        void INV() {
            int tmp = stack.pop();
            tmp = tmp*-1;
            stack.add(tmp);
        }

        void DUP() {
            int tmp =stack.peek();
            stack.add(tmp);
        }

        void SWP(){

            int n1 = stack.pop();
            int n2 = stack.pop();

            stack.add(n1);
            stack.add(n2);
        }

        int ADD() {
            int n1 = stack.pop();
            int n2 = stack.pop();
            return n1+n2;
        }

        int SUB() {
            int n1 = stack.pop();
            int n2 = stack.pop();
            return n2-n1;
        }

        long MUL() {
            long n1 = stack.pop();
            long n2 = stack.pop();
            return n1*n2;
        }

        int DIV() {
            int n1 = stack.pop();
            int n2 = stack.pop();

            if(n1 == 0)
            {
                this.isError = true;
                return -1;
            }

            if( (n1 < 0 && n2 > 0) || (n1 > 0 && n2 < 0) )
                return -1 * Math.abs(n2)/Math.abs(n1);

            return Math.abs(n2)/Math.abs(n1);
        }

        int MOD() {
            int n1 = Math.abs(stack.pop());
            int n2 = stack.pop();


            if(n1 == 0)
            {
                this.isError = true;
                return -1;
            }

            if(n2 < 0)
                return -1 * (Math.abs(n2) % n1);
            else
                return Math.abs(n2) % n1;
        }

        boolean sizeError() {
            if (this.stack.size() < 2)
            {
                this.isError = true;
                return true;
            }
            return false;
        }

    }

}
