class Solution {
    static void dfs(char[][] grid, boolean[][] visited, int n, int m) {

        if (n < 0 || n >= grid.length || m < 0 || m >= grid[0].length || grid[n][m] == '0'
            || visited[n][m]) {
            return;
        }

        visited[n][m] = true;

        dfs(grid, visited, n - 1, m);
        dfs(grid, visited, n, m + 1);
        dfs(grid, visited, n, m - 1);
        dfs(grid, visited, n + 1, m);
    }
    public int numIslands(char[][] grid) {
        int count = 0;
        int n = grid.length; // rows
        int m = grid[0].length; // columns

        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }
}
