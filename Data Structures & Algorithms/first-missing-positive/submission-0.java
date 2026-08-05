
    class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> s = new HashSet<>();
        
        for(int i : nums){
            s.add(i);
        }
        int max = Collections.max(s);

        for(int i=1;i<=nums.length;i++){
            if(s.contains(i)) continue;
            return i;
        }
        return max+1;
    }
}

