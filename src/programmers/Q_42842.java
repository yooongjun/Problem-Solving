package programmers;

class Q_42842 {

    static int x = 0, y = 0;

    public int[] solution(int brown, int yellow) {
        int[] answer = {};

        int total = brown + yellow;

        y = 3;
        x = 3;

        while(y*y <= total){

            if(total % y == 0)
            {

                x = total/y;

                int b = 2*x + 2*y -4;
                int y = total - b;

                if(b== brown && y == yellow){
                    break;
                }
            }
            y++;
        }

        answer = new int[2];
        answer[0] = x;
        answer[1] = y;

        return answer;
    }
}