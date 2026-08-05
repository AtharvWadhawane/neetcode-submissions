class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        boolean[]visited = new boolean [nums.length];
        backtrack(result,new ArrayList<>(),nums,visited);
        return result;   
    }
    private static void backtrack(List<List<Integer>>result,
    List<Integer>temp,int[]nums,boolean[]flag){

            if(temp.size() == nums.length){
                result.add(new ArrayList<>(temp));
                return;
            }
        for(int i=0;i<nums.length;i++){
            if(flag[i]) continue;
            if(i > 0 && nums[i] == nums[i-1] && !flag[i-1]) continue;
            temp.add(nums[i]);
            flag[i] = true;
            backtrack(result,temp,nums,flag);
            flag[i] = false;
            temp.remove(temp.size()-1);
        }
    }
}
