class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        for(int i=0;i<nums.length;i++){
            int idx = Math.abs(nums[i])-1;
            nums[idx] = -Math.abs(nums[idx]) ;
        }
        List<Integer>ls = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            if(nums[i] > 0) ls.add(i+1);
        }
           return ls;
    }
}