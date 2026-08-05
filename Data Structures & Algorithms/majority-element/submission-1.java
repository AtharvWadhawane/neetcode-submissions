class Solution {
    public int majorityElement(int[] nums) {
        int count = 1;
        int candidate = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i] == candidate){
                count++;
            }else{
                count--;
                if(count == 0){
                    count = 1;
                    candidate = nums[i];
                }
            }
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