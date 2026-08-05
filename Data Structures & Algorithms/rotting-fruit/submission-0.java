class Pair {
    int row, col, time;
    Pair(int row,int col,int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {

        int n = grid.length; // rows
        int m = grid[0].length; // cols
        Queue<Pair>queue = new LinkedList<>();
        int[][]visited = new int[n][m];
        int countFreshOranges = 0;

        //put initially rottened oranges in the queue
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 2){
                    queue.offer(new Pair(i,j,0));
                    visited[i][j] = 2;
                }

                if(grid[i][j] == 1) countFreshOranges++;
            }
        }

        //now lets see if neighbours are rotten or not ,(4 direction)
        int timeMax = 0;
        int[]rowD = {-1,0,+1,0};
        int[]colD = {0,+1,0,-1};
        int count = 0; // to match count of fresh oranges , else return -1

        //now we move in 4 directions of rotten orange cell to rot others 
        while(!queue.isEmpty()){
            int r = queue.peek().row;
            int c = queue.peek().col;
            int t = queue.peek().time;
            queue.poll();

            //each cell have 4 neighbours, so we search for fresh O in 4directions
            for(int i=0;i<4;i++){
                int nbrow = r + rowD[i];
                int nbcol = c + colD[i];
                timeMax = Math.max(timeMax,t);

                if(nbrow>=0 && nbrow<n  && nbcol >=0 && nbcol <m &&
                grid[nbrow][nbcol] == 1 && visited[nbrow][nbcol]!=2){
                    queue.offer(new Pair(nbrow,nbcol,t+1));
                    visited[nbrow][nbcol] = 2;
                    count++;
                }
            }

        }
        if(count != countFreshOranges) return -1;

        return timeMax;

    }
}