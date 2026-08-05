class Solution {
    //bruteF solution
    public boolean hasDuplicate(int[] nums) {
        int count = 0;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(nums[i] == nums[j]){
                    count++;
                    if(count == 2) return true;
                }
            }
            count = 0;
        }
        return false;
    }
}