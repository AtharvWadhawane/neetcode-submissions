class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(result, new ArrayList<>(), nums, 0,target);

        return result;
    }

    private static void backtrack(List<List<Integer>>result,
    List<Integer>temp, int[]nums, int start, int remaining){

        if(remaining == 0){
            result.add(new ArrayList<>(temp));
            return;
        }
        if(remaining<0) return;

        for(int i=start;i<nums.length;i++){
            temp.add(nums[i]);

            backtrack(result,temp,nums,i,remaining-nums[i]);

            temp.remove(temp.size()-1);
        }   
    }
}
