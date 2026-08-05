class Solution {
    public int findKthLargest(int[] nums, int k) {
        int temp = -1;
        PriorityQueue<Integer>maxheap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i : nums){
            maxheap.offer(i);

            // if(maxheap.size() > k) maxheap.poll();
        }

        for(int i=0;i<k;i++){
            temp = maxheap.poll();
            if(i == k-1) return temp;
        }
        return temp;
    }
}
