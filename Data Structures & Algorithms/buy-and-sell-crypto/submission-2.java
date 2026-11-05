//tabulation 
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][] dp = new int[n + 1][3];

        for (int curr = n - 1; curr >= 0; curr--) {

            for (int k = 1; k <= 2; k++) {

                if (k == 2) {
                    int buy = dp[curr + 1][1] - prices[curr];
                    int skip = dp[curr + 1][2];

                    dp[curr][k] = Math.max(buy, skip);
                } else {
                    int sell = dp[curr + 1][0] + prices[curr];
                    int skip = dp[curr + 1][1];

                    dp[curr][k] = Math.max(sell, skip);
                }
            }
        }

        return dp[0][2];
    }
}