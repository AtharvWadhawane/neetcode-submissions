class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer>map = new HashMap<>();
        map.put(0,1); // prefixsum,frequency
        int prefixsum = 0;
        int count = 0;

        for(int i=0;i<nums.length;i++){
            prefixsum += nums[i];

            int need = prefixsum - k;

            if(map.containsKey(need)){
                count += map.get(need);
            }
            map.put(prefixsum,map.getOrDefault(prefixsum,0)+1);

        }

        return count;
    }
}