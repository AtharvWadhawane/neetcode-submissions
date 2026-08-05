class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> s = new HashSet<>();
        
        for(int num : nums){
            if(num > 0)
                s.add(num);
        }

        for(int i = 1; i <= nums.length; i++){
            if(!s.contains(i)){
                return i;
            }
        }

        return nums.length + 1;
    }
}