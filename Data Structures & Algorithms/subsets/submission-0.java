class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        result.add(new ArrayList<>());

        for(int i : nums){
            int size = result.size();

            for(int j=0;j<size;j++){
                List<Integer> cpy = new ArrayList<>(result.get(j));
                cpy.add(i);
                result.add(cpy);                
            }
        }
        return result;
    }
}
