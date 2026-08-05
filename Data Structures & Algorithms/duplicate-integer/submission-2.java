class Solution {
    public boolean hasDuplicate(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for(int i=0;i<nums.length-1;i++){
            int j = i+1;
            if(nums[i] == nums[j]){
                count++;
                if(count == 1) return true;
            }
            count = 0;
            j++;
        }
        return false;
    }
}