class Solution {
    public int leastInterval(char[] tasks, int n) {
        //only uppercase letters 
        int[]freq = new int[26];

        for(char c : tasks){
            freq[c-'A']++;
        }

        //maxheap to pick most frequent task first

        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());

        for(int f : freq) {
            if(f>0)    
            maxheap.offer(f);
        }

        int time = 0;

        //queue to keep task until cooldown, after cooldown again add to maxheap

        //queue each element [] will have freq,time
        Queue<int[]>queue = new LinkedList<>();

        while(!maxheap.isEmpty() || !queue.isEmpty()){
            time++;

            if(maxheap.isEmpty()){
                time = queue.peek()[1];
            }else{
                int count = maxheap.poll()-1;
                if(count>0){
                    queue.add(new int[]{count,time+n});
                }
            }
            if(!queue.isEmpty() && queue.peek()[1] == time){
                maxheap.offer(queue.poll()[0]);
            }
        }
        return time;

    }
}
