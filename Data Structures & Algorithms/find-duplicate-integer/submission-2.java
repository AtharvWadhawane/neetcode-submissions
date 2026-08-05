class Solution {
    public int findDuplicate(int[] nums) {
        
        //O(nlogn) - TC  , SC - O(1)

        Arrays.sort(nums);
        int j = 1;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == nums[j]) return nums[i];

            else j++;
        }
        return -1;
    }
}
