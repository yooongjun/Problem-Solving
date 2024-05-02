package programmers;
import java.util.*;

class Q_159993 {

    static int mx[] = {0, -1, 0, 1};
    static int my[] = {-1, 0, 1, 0};
    static int time = 0;
    static int X, Y;

    public int solution(String[] maps) {
        int answer = 0;
        Move position_S = null, position_L = null;

        X = maps.length;
        Y = maps[0].length();


        for(int i = 0; i < X; i++){
            for(int j = 0; j < Y; j++){
                char c = maps[i].charAt(j);
                if(c == 'S'){
                    System.out.println(c + "," + i+ "," +j);
                    position_S = new Move(i, j, 0);
                }

                if(c == 'L'){
                    System.out.println(c + "," + i+ "," +j);
                    position_L = new Move(i, j, 0);
                }
            }
        }


        if(!find(maps, 'L', position_S) || !find(maps, 'E', position_L)){
            answer = -1;
        }
        else
        {
            answer = time;
        }

        return answer;
    }

    static boolean find(String[] s, char target, Move start){
        Queue<Move> queue = new LinkedList<>();
        boolean visit[][] = new boolean[X][Y];
        queue.add(start);
        visit[start.x][start.y] = true;


        while(!queue.isEmpty()){

            Move move = queue.poll();

            for(int i = 0; i < 4; i++){

                int xx = move.x + mx[i];
                int yy = move.y + my[i];

                if(xx >= 0 && xx < X && yy >= 0 && yy < Y && !visit[xx][yy] && s[xx].charAt(yy) != 'X')
                {
                    if(s[xx].charAt(yy) == target){
                        System.out.println(s[xx].charAt(yy) +", target: "+ target);
                        time += move.cost + 1;
                        return true;
                    }

                    visit[xx][yy] = true;
                    queue.add(new Move(xx,yy, move.cost + 1));
                }

            }

        }

        return false;
    }

    static class Move{

        int x, y, cost;

        public Move(int x, int y, int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

    }


}
