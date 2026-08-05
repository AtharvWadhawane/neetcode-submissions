class Solution {
    public int lastStoneWeight(int[] stones) {

        if(stones.length == 1) return stones[0];
        PriorityQueue<Integer>pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i : stones){
            pq.offer(i);
        }

        while(!(pq.size()==1 || pq.size()==0)){
            int firstlargest = pq.poll();
            int secondlargest = pq.poll();

            if(firstlargest == secondlargest) continue;

            firstlargest -= secondlargest;

            pq.offer(firstlargest); 
        }
        if(pq.size() == 0) return 0;
        return pq.peek();
    }
}
