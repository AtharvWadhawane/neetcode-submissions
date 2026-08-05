class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer>maxheap = new PriorityQueue<>(Collections.reverseOrder());

        long ans = 0;

        for(int i : gifts){
            maxheap.offer(i);
        }

        for(int i=0;i<k;i++){
            int temp  = maxheap.poll();
            maxheap.offer((int) Math.sqrt(temp));
        }

        while(!maxheap.isEmpty()){
            ans += maxheap.poll();
        }
        return ans;
    }
}