class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        // lets get our multiple sources and put them in a queue

        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 0){
                    q.offer(new int[]{i,j   });
                }
            }
        }

        int[][]directions = {{1,0},{-1,0},{0,1},{0,-1}};
        //we look in all 4 directions 

        while(!q.isEmpty()){
            int[]cell = q.poll();
            int r = cell[0], c = cell[1];

            for(int[]d : directions){
                int nbr = r+d[0] , nbc = c+d[1];
                if(nbr<0 || nbc<0 || nbr>=n || nbc>=m || grid[nbr][nbc] != Integer.MAX_VALUE){
                    continue;
                }
                grid[nbr][nbc] = grid[r][c] + 1;
                q.offer(new int[]{nbr,nbc});
            }
        }
    }
}
