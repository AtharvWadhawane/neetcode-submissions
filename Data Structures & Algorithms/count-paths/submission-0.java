//memo

class Solution {
    int[][]dp;
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];

        for(int[]row : dp){
            Arrays.fill(row,-1);
        }

        return paths(0,0,m,n);
    }

    private int paths(int i,int j,int rows,int cols){
        
        if(i == rows-1 && j == cols-1) return 1; //reached finish

        if(i>=rows || j >= cols) return 0; //out of bounds

        if(dp[i][j] != -1) return dp[i][j];

        return dp[i][j] = paths(i,j+1,rows,cols) + paths(i+1,j,rows,cols); //right + down paths
    }
}