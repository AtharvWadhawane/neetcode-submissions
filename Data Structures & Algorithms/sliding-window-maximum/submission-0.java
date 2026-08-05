class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer>ls = new ArrayList<>();

        int l=0, r=k-1;

        while(r<nums.length){
            int currmax = findmax(nums,l,r);

            ls.add(currmax);
            l++;
            r++;
        }
        int[] result = new int[ls.size()];
        for (int i = 0; i < ls.size(); i++) {
            result[i] = ls.get(i);
        }
        return result;
    }
    public static int findmax(int[]arr,int l,int r){
        int max = Integer.MIN_VALUE;

        for(int i=l;i<=r;i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        return max;
    }
}
