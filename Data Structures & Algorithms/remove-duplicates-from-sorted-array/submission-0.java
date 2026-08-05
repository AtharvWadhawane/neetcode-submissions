class Solution {
    public int removeDuplicates(int[] nums) {
        int house = 0;
        int broker = 1;

        while(broker < nums.length){

            if(nums[broker] != nums[broker-1]){
                nums[house+1] = nums[broker];
                house++;
            }
            broker++;
        }
        return house+1;
    }
}