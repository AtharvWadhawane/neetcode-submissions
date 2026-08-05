class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxarea  = 0;
        int[]r = new int[n];
        int[]l = new int[n];
        findRightLimit(heights,n,r); 
        findLeftLimit(heights,n,l);


        for(int i=0;i<n;i++){
            int area = heights[i] * (r[i]-l[i]-1);

            if(area > maxarea) maxarea = area;
        }
        return maxarea;
    }
    public static void findRightLimit(int[]ht,int size,int[]r){
        ArrayDeque<Integer>st = new ArrayDeque<>();

        // reverse traversal
        //nearest right smallest
        for(int i=size-1;i>=0;i--){
            while(!st.isEmpty() && ht[st.peek()]>=ht[i]){
                st.pop();
            }
            r[i] = st.isEmpty() ? size : st.peek();
            st.push(i); // we will push the bar index not ht  
        }
    }

     public static void findLeftLimit(int[]ht,int size,int[]l){
        ArrayDeque<Integer>st = new ArrayDeque<>();

        //nearest left smallest

        for(int i=0;i<size;i++){
            while(!st.isEmpty() && ht[st.peek()]>=ht[i]){
                st.pop();
            }
            l[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i); // we will push the bar index not ht  
        }
    }
}