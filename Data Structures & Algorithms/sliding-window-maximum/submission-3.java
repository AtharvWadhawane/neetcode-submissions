class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[]result = new int[n-k+1];
        Deque<Integer>dq = new ArrayDeque<>();

        for(int i=0;i<n;i++){

            //keep only relevant elements in the window , remove older ones 
            if(!dq.isEmpty() && dq.peekFirst() <= i-k) {
                dq.pollFirst();
            }

            //remove smaller elements 
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }
            dq.offerLast(i);

            // record max for current window
            if(i >= k-1){
                result[i-k+1] = nums[dq.peekFirst()];
            }
        }
        return result;
    }
}