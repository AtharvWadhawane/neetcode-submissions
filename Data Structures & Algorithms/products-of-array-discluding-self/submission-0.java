class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[]result = new int[nums.length];

        for(int i=0;i<nums.length;i++){
            result[i] =  pro(nums,i);
        }
        return result;
    }
    public static int pro(int[]arr,int index){
        int totalexcept = 1;
        for(int i=0;i<arr.length;i++){
            if(i == index) continue;
            totalexcept *= arr[i];
        }
        return totalexcept;
    }
}  
