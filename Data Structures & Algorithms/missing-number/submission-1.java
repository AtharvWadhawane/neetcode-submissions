class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int xor = 0;

        //for all numbers (expectation)
        for(int i=0;i<=n;i++){
            xor ^= i;
        }

        //all element from array , (real)
        for(int i : nums){
            xor ^= i;
        }
        return xor;
    }
}