// O(n^2) solution 
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[]ans = new int[n];

        for(int i=0;i<n;i++){
            ans[i] = 1;

            for(int j=0;j<i;j++){
                if(nums[j] < nums[i]){
                    ans[i] = Math.max(ans[i],ans[j]+1);
                }
            }
        }

        int maxi = 1;
        for(int i : ans) maxi = Math.max(maxi,i);

        return maxi;

    }
}