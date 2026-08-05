class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        for(int i=0;i<nums.length;i++){
            int idx = Math.abs(nums[i]);
            if(nums[idx-1] > 0){
                nums[idx-1] = nums[idx-1]*-1;
            }
        }
        List<Integer>ls = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            if(nums[i] > 0) ls.add(i+1);
        }
           return ls;
    }
}