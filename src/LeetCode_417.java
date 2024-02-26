import java.util.*;
    class LeetCode_417 {

        static boolean[][] reachPacificOcean, reachAtlanticOcean;
        static int x , y;
        static int[] mx = {0, -1, 0, 1};
        static int[] my = {-1, 0, 1, 0};

        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            List<List<Integer>> result = new ArrayList<List<Integer>>();

            x = heights.length;
            y = heights[0].length;

            reachPacificOcean = new boolean[x][y];
            reachAtlanticOcean = new boolean[x][y];

            for(int i = 0; i < x; i++){
                for(int j = 0; j < y; j++){
                    bfs(i,j,heights);

                    if(reachPacificOcean[i][j] && reachAtlanticOcean[i][j])
                    {
                        result.add(new ArrayList<>(Arrays.asList(i,j)));
                    }
                }
            }

            return result;
        }

        static void bfs(int i, int j, int[][] heights){
            Queue<Cell> queue = new LinkedList<>();
            boolean visit[][] = new boolean[x][y];

            queue.add(new Cell(i, j));
            visit[i][j] = true;

            while(!queue.isEmpty()){

                Cell cell = queue.poll();

                for(int k = 0; k < 4; k++)
                {
                    int xx = cell.x + mx[k];
                    int yy = cell.y + my[k];

                    if(xx < 0 || yy < 0 || xx >= x || yy >= y){
                        if(k <= 1){
                            reachPacificOcean[i][j] = true;
                        }
                        else
                        {
                            reachAtlanticOcean[i][j] = true;
                        }
                        continue;
                    }

                    if(!visit[xx][yy] && heights[xx][yy] <= heights[cell.x][cell.y]){
                        visit[xx][yy] = true;
                        queue.add(new Cell(xx,yy));
                    }
                }
            }
        }

        static class Cell{
            int x, y;

            Cell(int x, int y){
                this.x = x;
                this.y = y;
            }
        }
    }
