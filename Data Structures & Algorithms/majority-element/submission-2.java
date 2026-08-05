class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = nums[0];
        for(int i : nums){
            if(count == 0){
                candidate = i;
            }
            count+= (i == candidate) ? 1 : -1;
        }
        //lets verify the candidate : 
        int c = 0;
        for(int i : nums){
            if(i == candidate) c++;
        }

        if(c > nums.length/2) 
        return  candidate;

        return -1;
    }
}