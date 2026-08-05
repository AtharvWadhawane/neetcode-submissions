class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length-1;

        int lmax = Integer.MIN_VALUE;
        int rmax = Integer.MIN_VALUE;
        int container = 0;

        while(l<r){
            if(height[l]<=height[r]){
                if(height[l]>=lmax){
                    lmax = height[l];
                }
                else{
                    container += lmax-height[l]; 
                }
                l++;
            }
            else{
                if(height[r]>=rmax){
                    rmax = height[r];
                }
                else{
                    container += rmax-height[r];
                }
                r--;
            }
        }
        return container;
    }
}
