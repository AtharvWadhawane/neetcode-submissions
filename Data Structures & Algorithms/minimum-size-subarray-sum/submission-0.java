class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minlen = Integer.MAX_VALUE;
        int n = nums.length;
        int sum = 0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                sum += nums[j];
                if(sum >= target){
                    int len = j-i+1;
                    if(len < minlen) minlen = len;
                }
            }
            sum = 0;
        }
        return minlen == Integer.MAX_VALUE ? 0 : minlen;
    }
}