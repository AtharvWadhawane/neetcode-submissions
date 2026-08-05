class Solution {
    public int findDuplicate(int[] nums) {
        

        //better code than slow and fast pointer

        int n = nums.length;

        int[]hash = new int[n];

        for(int i=0;i<n;i++){
            hash[nums[i]]++;

            if(hash[nums[i]]>1) return nums[i];
        }

        return -1;
    }
}
