class Solution {
    public int rob(int[] nums) {
        
        int[]memo = new int[nums.length+1];

        Arrays.fill(memo,-1);
        
        return recurse(0,nums,memo);
    }

    private int recurse(int i,int[]nums,int[]memo){

        if(i>=nums.length) return 0;

        if(memo[i] != -1) return memo[i];

        //rob
        int robCurrent = nums[i] + recurse(i+2,nums,memo);

        //dont rob (skip)
        int skipCurrent = recurse(i+1,nums,memo);

        memo[i] = Math.max(robCurrent,skipCurrent);

        return memo[i];
   
    }
}