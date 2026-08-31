class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[]ans = new int[nums1.length];

        for(int i=0;i<nums1.length;i++){
            ans[i] = findNext(nums1[i],nums2);
        }   

        return ans;
    }

    static int findNext(int num,int[]arr){
        for(int i=0;i<arr.length;i++){
            if(num == arr[i]){
                int j=i+1;
                while(j<arr.length){
                    if(arr[j] > num) return arr[j];

                    j++;
                }

            }
        }
        return -1;
    }
}