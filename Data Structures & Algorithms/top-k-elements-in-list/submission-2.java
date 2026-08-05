class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        //Make the Frequency Table 
        Map<Integer,Integer> freqmap = new HashMap<>();
        for(int i : nums){
            freqmap.put(i,freqmap.getOrDefault(i,0)+1);
        }

        //Make the buckets and assign elements to appropriate  frequency bucket
        List<Integer>[]buckets = new List[nums.length+1]; //max size possible size+1

       for(Map.Entry<Integer,Integer> var : freqmap.entrySet()){
        int number  = var.getKey();
        int fcount  = var.getValue();

        if(buckets[fcount] == null){
            buckets[fcount] = new ArrayList<>();
        }
        buckets[fcount].add(number);
    }

    //now traverse from the last to first bucket to pick top k felements
    //store the answer in a new array 

    int[]result = new int[k]; 
    int lever = 0;
    for(int i=buckets.length-1;i>=0 && lever < k; i--){
        if(buckets[i]!=null){
            for(int a : buckets[i]){
                result[lever++] = a;
                if(lever == k) break;
            }
        }
    }
    return result;

    }
}
