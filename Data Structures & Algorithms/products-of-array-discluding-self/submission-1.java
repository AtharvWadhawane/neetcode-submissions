class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[]result = new int[nums.length];

        int check=0,total=1;
        for(int i:nums){
            if(i == 0){
                check++;
                continue;
            }
            total *= i;
        }
        if(check > 1){
                Arrays.fill(result,0);
                return result;
            }
        for(int i=0;i<nums.length;i++){

            if(check == 1){ //zero exist in the array
                if(nums[i]!=0){ //when element is not zero
                    result[i] = 0;
                }
                else result[i] = total;  //when element is zero
            }
            
            else{ //zero does not exist
            result[i] = total/nums[i];

            }
        }
        return result;
    }
   
}  
