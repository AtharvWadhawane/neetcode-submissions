class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer>map = new HashMap<>(); // num and its freq

        for(int i : nums){
            map.put(i,map.getOrDefault(i,0)+1); 
        }

        //now store key-value pair(num,freq) in priority q (min heap)

        PriorityQueue<Map.Entry<Integer,Integer>> minheap = new PriorityQueue<>((a,b) -> a.getValue() - b.getValue());

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            minheap.offer(entry);
            if(minheap.size() > k) minheap.poll();
        }

        int[]result = new int[k];

        for(int i=0;i<k;i++){
            result[i] = minheap.poll().getKey();
        }

        return result;
    }
}