class Solution {
    public int rob(int[] nums) {
        
        if(nums.length == 1) return nums[0];


        //Rob first ,cannot rob last
        int[]memo1 = new int[nums.length];
        Arrays.fill(memo1,-1);
        int path1 = maxi(0,nums.length-2,nums,memo1);


        //Rob second , can rob last 
        int[]memo2 = new int[nums.length];
        Arrays.fill(memo2,-1);
        int path2 = maxi(1,nums.length-1,nums,memo2);

        return Math.max(path1,path2);
    }

    private int maxi(int i, int limit, int[] nums, int[] memo) {

        if (i > limit)
            return 0;

        if(memo[i] != -1) return memo[i];

        //rob current
        int robCurrent = nums[i] + maxi(i + 2, limit, nums,memo);

        //skip current
        int skipCurrent = maxi(i + 1, limit, nums,memo);

        memo[i] = Math.max(robCurrent, skipCurrent);

        return memo[i];

    }
}