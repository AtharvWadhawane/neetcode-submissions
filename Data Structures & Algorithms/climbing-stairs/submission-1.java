class Solution {
    public int climbStairs(int n) {
        // Create a memo array of size n + 1
        int[] memo = new int[n + 1];
        
        // Initialize with -1 to track unvisited steps
        Arrays.fill(memo, -1);
        
        // Start from the top step (n) and look backward
        return countWays(n, memo);
    }

    private int countWays(int i, int[] memo) {
        // Base Case 1: You are at the bottom ground step (Step 0). 
        // There is exactly 1 valid way to "stay" there.
        if (i == 0) return 1;
        
        // Base Case 2: You stepped past the bottom into negative territory. 
        // This is an invalid path, so it yields 0 ways.
        if (i < 0) return 0;

        // Return the cached result if we already calculated this step
        if (memo[i] != -1) return memo[i];

        // Choice 1: The current step was reached by taking a 1-step hop from (i - 1)
        int takeOneStep = countWays(i - 1, memo);

        // Choice 2: The current step was reached by taking a 2-step hop from (i - 2)
        int takeTwoSteps = countWays(i - 2, memo);

        // Cache the sum of both paths before returning
        return memo[i] = takeOneStep + takeTwoSteps;
    }
}
