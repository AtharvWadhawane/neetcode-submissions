//Hire and Fire

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0, sum = 0;
        int minlen = Integer.MAX_VALUE;
        int n = nums.length;

        for (int j = 0; j < n; j++) {
            sum += nums[j];
                while (sum>=target) {
                    minlen = Math.min(minlen,j-i+1);
                    sum -= nums[i];
                    i++;
                }
            }

        return minlen == Integer.MAX_VALUE ? 0 : minlen;
    }
}