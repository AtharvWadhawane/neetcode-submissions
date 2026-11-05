//Memo

class Solution {
    int[][]dp;
    public int maxProfit(int[] prices) {
        dp = new int[prices.length][3];

        for(int[]row : dp) Arrays.fill(row,-1);

        return profit(prices,0,2);
    }

    private int profit(int[]arr,int i,int k){
        if(i == arr.length || k == 0) return 0;

        if(dp[i][k] != -1) return dp[i][k];

        int ans;

        if(k == 2){ // buy

            int c1 = profit(arr,i+1,k-1) - arr[i]; //take
            int c2 = profit(arr,i+1,k); // skip

            ans = Math.max(c1,c2);
        }
        else { //sell

            int c1 = profit(arr,i+1,k-1) + arr[i]; //take
            int c2 = profit(arr,i+1,k); // skip

            ans = Math.max(c1,c2);
        }

        return dp[i][k] = ans;
    }
}