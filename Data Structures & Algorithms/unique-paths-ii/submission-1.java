//Tabulation 
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m + 1][n + 1];

        // If destination is blocked no path exists
        if (obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }

        // Base case --> finishline reached
        dp[m - 1][n - 1] = 1;

        // Fill DP from bottom-right to top-left
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                // Obstacle: no paths through this cell
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }

                // Preserve destination base case
                if (i == m - 1 && j == n - 1) {
                    continue;
                }

                dp[i][j] = dp[i][j + 1] + dp[i + 1][j];
            }
        }

        return dp[0][0];
    }
}