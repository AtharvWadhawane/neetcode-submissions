class Solution {
    public int largestRectangleArea(int[] heights) {
        int gminh = Integer.MAX_VALUE;
        int maxarea = Integer.MIN_VALUE;

        for(int i=0;i<heights.length;i++){
            for(int j=i;j<heights.length;j++){
                int min = Math.min(heights[i],heights[j]);
                if(min < gminh){
                    gminh = min;
                }
                int width = j-i+1;
                int area = gminh * width;
                if(area > maxarea) maxarea = area;
            }
            gminh = Integer.MAX_VALUE;
        }
        return maxarea;
    }
}
