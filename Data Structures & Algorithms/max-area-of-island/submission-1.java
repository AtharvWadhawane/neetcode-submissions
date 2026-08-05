class Solution {

    static int dfs(int[][] grid,int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length ||
                grid[r][c] == 0)
            return 0;

        grid[r][c] = 0;

        int area = 1;
        area += dfs(grid,r - 1, c);
        area += dfs(grid, r, c + 1);
        area += dfs(grid, r + 1, c);
        area += dfs(grid, r, c - 1);

        return area;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int maxarea = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    maxarea = Math.max(maxarea,dfs(grid,i,j));
                }
            }
        }
        return maxarea;
    }
}
