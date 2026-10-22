//Tabulation :  (left to right )
//base case : if(i == n || j == m) return 0


//tabulation : 

class Solution {
    int[][]dp;
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        dp = new int[n+1][m+1];

        //preload with base case 
        // here for dp[n][i] , dp[i][m] = 0 well in java it is already zero 

        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(text1.charAt(i) == text2.charAt(j)){
                    dp[i][j] = 1 + dp[i+1][j+1];
                }
                else {
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }
        return dp[0][0];
    }
}
