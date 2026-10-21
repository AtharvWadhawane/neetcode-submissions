// pos - neg = target
//pos + neg = totalsum

//pos = (target+totalsum)/2

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int totalsum = 0;
        for(int i : nums) totalsum += i;

        //our target should be in the range of [-totalsum,totalsum]
        if(Math.abs(target) > totalsum) return 0;

        //if odd then no ways
        if((totalsum+target)%2 != 0 )return 0;   
        
        int sum = (totalsum + target)/2;

        int[][]dp = new int[n+1][sum+1];

        //preload dp with base case 
        for(int i=0;i<=n;i++){
            dp[i][0] = 1;
        }

        for(int i=n-1;i>=0;i--){
            for(int s=0;s<=sum;s++){
                //skip
                int skip = dp[i+1][s];

                //take
                int take = 0;
                if(nums[i] <= s){
                    take = dp[i+1][s-nums[i]];
                }

                dp[i][s] = take + skip;
            }
        }

        return dp[0][sum];
    }
}