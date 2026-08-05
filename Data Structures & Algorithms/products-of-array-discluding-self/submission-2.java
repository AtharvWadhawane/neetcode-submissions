class Solution {
    public int[] productExceptSelf(int[] nums) {
        int total = 1;
        int zeroCount = 0;

        for(int num : nums){
            if(num == 0) zeroCount++;
            else total *= num;
        }

        for(int i = 0; i < nums.length; i++){
            if(zeroCount > 1){
                nums[i] = 0;
            }
            else if(zeroCount == 1){
                nums[i] = (nums[i] == 0) ? total : 0;
            }
            else{
                nums[i] = total / nums[i];
            }
        }

        return nums;
    }
}