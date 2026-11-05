//tabulation 
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][] dp = new int[n + 1][3];

        for (int i = n - 1; i >= 0; i--) {

            for (int k = 1; k <= 2; k++) {

                if (k == 2) { // buy

                    int c1 = dp[i + 1][k - 1] - prices[i]; // take
                    int c2 = dp[i + 1][k];                // skip

                    dp[i][k] = Math.max(c1, c2);
                } 
                else { // sell

                    int c1 = dp[i + 1][2] + prices[i]; // take
                    int c2 = dp[i + 1][k];             // skip

                    dp[i][k] = Math.max(c1, c2);
                }
            }
        }

        return dp[0][2];
    }
}