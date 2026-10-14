class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int totalsum = 0;
        for(int i : nums) totalsum +=i;

        if(totalsum%2 != 0 )return false; //total sum is odd (cannot split is 2 equal subsets)

        int target = totalsum/2;

        Boolean[][]memo = new Boolean[n][target+1];

        return recurse(0,target,nums,memo);

    }

    private boolean recurse(int i,int target,int[]nums, Boolean[][]memo){

        if(target == 0) return true;

        if(i == nums.length) return false;

        if(memo[i][target] != null) return memo[i][target];

        boolean take = false;
        if(target >= nums[i]){
            take = recurse(i+1,target-nums[i],nums,memo);
        }

        boolean skip = recurse(i+1,target,nums,memo);

        return memo[i][target] = take || skip;
    }
}