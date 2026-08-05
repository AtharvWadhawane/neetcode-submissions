class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>>result = new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0;i<nums.length-2;i++){
            //avoid duplicates for i
            if(i>0 && nums[i] == nums[i-1])continue;
            int l = i+1;
            int r = nums.length-1;
            int target = -1 * nums[i];

            while(l<r){
                int sum = nums[l]+nums[r];

                if(sum == target){
                    result.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    l++;
                    r--;

                    //avoid duplicates for l and r 
                    while(l<r && nums[l] == nums[l-1])l++;
                    while(l<r && nums[r] == nums[r+1])r--;
                }
                else if(sum > target) r--;
                else l++;
            }
        }
            return result;
    }
}