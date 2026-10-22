//Memoiozation

class Solution {
    int[][]dp;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        dp = new int[n+1][n+1];

        for(int[]row : dp){
            Arrays.fill(row,-1);
        }

        return find(nums,n,0,-1);

    }

    private int find(int[]nums,int n,int i,int prev){
        if(i == n) return 0;

        if(dp[i][prev+1] != -1) return dp[i][prev+1];

        //we have choice
        if(prev == -1 || nums[i] > nums[prev]){
            int take = 1 + find(nums,n,i+1,i);
            int skip = find(nums,n,i+1,prev);

            return dp[i][prev+1] = Math.max(take,skip);
        }

        //no choice (previous  val greater than current)
        return dp[i][prev+1] = find(nums,n,i+1,prev);
    }
}