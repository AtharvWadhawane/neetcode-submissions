class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer>freqmap = new HashMap<>(); //element-its frequency

        for(int i : nums){
            freqmap.put(i,freqmap.getOrDefault(i,0) + 1);
        }

        //max freq = size of array
        List<Integer>[] bucket = new List[nums.length+1]; //each idx is freq

        for(int key : freqmap.keySet()){
            int freq = freqmap.get(key);

            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        List<Integer>temp = new ArrayList<>();

        for(int i=bucket.length-1;i>=0 && temp.size() < k; i--){
            if(bucket[i] != null){
                temp.addAll(bucket[i]);
            }
        }

        //convert arraylist to array
        int[]ans = new int[k];
        for(int i=0;i<k;i++){
            ans[i] = temp.get(i);
        }
        return ans;

    }
}