// there can be atmost 2 candidates which can be greater than n/3

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;

        int candi1 = 0,candi2 = 0;
        int count1 = 0 , count2 = 0;

        for(int i : nums){
            if(i == candi1) count1++;
            else if(i == candi2) count2++;
            else if(count1 == 0){
                candi1 = i;
                count1 = 1;
            } 
            else if(count2 == 0) {
                candi2 = i;
                count2 = 1;
            }
            else {

                count1--;
                count2--;
            }
        }

         count1 = 0 ;
         count2  = 0;

        for(int i : nums){
            if(i == candi1) count1++;
            else if(i == candi2) count2++;
        }

        List<Integer>result = new ArrayList<>();
        
        if(count1 > n/3) result.add(candi1);
        if(count2 > n/3) result.add(candi2);

        return result;
    }
}