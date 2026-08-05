class Solution {

    static int dfs(int[][]grid,boolean[][]visited,int r,int c){
        if(r<0 || r>=grid.length || c<0 || c>=grid[0].length || grid[r][c] == 0
        || visited[r][c]) return 0;

        visited[r][c] = true;
        int area=1;

        area += dfs(grid,visited,r-1,c);
        area += dfs(grid,visited,r,c+1);
        area += dfs(grid,visited,r+1,c);
        area += dfs(grid,visited,r,c-1);

        return area;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][]visited = new boolean[n][m];
        int maxarea = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] != 0 && !visited[i][j]){
                    int area = dfs(grid,visited,i,j);
                    maxarea = Math.max(maxarea,area);
                }
            }
        }
        return maxarea;
    }
}
