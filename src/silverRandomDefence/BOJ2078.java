package silverRandomDefence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 무한이진트리
 */
public class BOJ2078 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bufferedReader.readLine().split(" ");

        int l = Integer.parseInt(s[0]);
        int r = Integer.parseInt(s[1]);

        Node node = new Node(l, r);

        while (!node.isRoot()) {
            if (node.isLeft()) {
                node.goRight();
            } else {
                node.goLeft();
            }
        }

        System.out.println(node.leftCnt + " " + node.rightCnt);
    }

    static class Node{

        int left, right;
        int leftCnt, rightCnt;

        void goLeft() {

            if (this.left == 1) {
                rightCnt += this.right - this.left;
                this.right = 1;
            }
            else {
                rightCnt += this.right / this.left;
                this.right %= this.left;
            }

        }

        void goRight() {

            if (this.right == 1) {
                leftCnt += this.left - this.right;
                this.left = 1;
            }
            else {
                leftCnt += this.left / this.right;
                this.left %= this.right;
            }


        }

        boolean isRoot() {
            return left == right;
        }

        boolean isLeft() {
            if (left > right) {
                return true;
            }

            return false;
        }

        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }


}
