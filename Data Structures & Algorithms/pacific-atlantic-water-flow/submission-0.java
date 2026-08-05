class Solution {
    public List<List<Integer>> pacificAtlantic(int[][]grid) {

        List<List<Integer>> result = new ArrayList<>();

        int n = grid.length; // rows
        int m = grid[0].length; // cols

        boolean[][]pacific = new boolean[n][m];
        boolean[][]atlantic = new boolean[n][m];


        //top and bottom horizontal 
        for(int c=0;c<m;c++){
            dfs(0,c,grid[0][c],grid,pacific); // top pacific

            dfs(n-1,c,grid[n-1][c],grid,atlantic); // bottom atlantic 
        }
        //left and right  vertical 
        for(int r=0;r<n;r++){
            dfs(r,0,grid[r][0],grid,pacific); // left pacific

            dfs(r,m-1,grid[r][m-1],grid,atlantic); //right atlantic 
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    result.add(List.of(i,j));
                }
            }
        }
        return result;
    }

    private void dfs(int r,int c, int prevHeight,int[][]grid,boolean[][]ocean){
        int n = grid.length;
        int m = grid[0].length;

        if(r<0 || c<0 || r>=n || c>=m || ocean[r][c] || 
        grid[r][c] < prevHeight){
            return;
        }
        ocean[r][c] = true;

        //explore 4 directions 

        dfs(r+1,c,grid[r][c],grid,ocean);
        dfs(r,c+1,grid[r][c],grid,ocean);
        dfs(r-1,c,grid[r][c],grid,ocean);
        dfs(r,c-1,grid[r][c],grid,ocean);
    }   
}