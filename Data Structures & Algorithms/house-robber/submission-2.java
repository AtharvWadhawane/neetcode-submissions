//right to left approach 

class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        // Create a memo array of size N
        int[] memo = new int[nums.length];
        
        // Initialize the memo array with -1 to represent unvisited states
        Arrays.fill(memo, -1);
        
        // Start the recursion from the very last house (index N-1)
        return robFrom(nums.length - 1, nums, memo);
    }

    private int robFrom(int i, int[] nums, int[] memo) {
        // Base Case 1: If we step past the first house into negative indices
        if (i < 0) {
            return 0;
        }
        
        // Base Case 2: Only one house left to look at (index 0), so rob it!
        if (i == 0) {
            return nums[0];
        }

        // Return the result immediately if we have already calculated it
        if (memo[i] != -1) {
            return memo[i];
        }

        // Choice 1: Rob current house 'i' and skip back to 'i - 2'
        int robCurrent = nums[i] + robFrom(i - 2, nums, memo);

        // Choice 2: Skip current house 'i' and check the previous house 'i - 1'
        int skipCurrent = robFrom(i - 1, nums, memo);

        // Save the best choice into the memo array before returning
        memo[i] = Math.max(robCurrent, skipCurrent);
        
        return memo[i];
    }
}
