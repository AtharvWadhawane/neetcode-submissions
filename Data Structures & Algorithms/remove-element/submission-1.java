class Solution {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        for(int i : nums){
            if(i == val) continue;
            nums[count++] = i;
        }
        return count;   
    }

}