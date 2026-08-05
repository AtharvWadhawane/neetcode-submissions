class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(result,new ArrayList<>(),nums,0,0,target);

        return result;
        
    }

    private static void backtrack(List<List<Integer>>result,
    List<Integer>temp,int[]nums,int start,int currsum ,int target){

        
        if(currsum == target){
            result.add(new ArrayList<>(temp));
            return;
        }
        if(currsum > target) return;

        for(int i=start;i<nums.length;i++){
            temp.add(nums[i]); //choose

            backtrack(result,temp,nums,i,currsum + nums[i],target);

            temp.remove(temp.size()-1);
        }
    }
}
