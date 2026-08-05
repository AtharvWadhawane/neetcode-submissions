class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[]arr = new int[nums.length];

        for(int i=0;i<nums.length;i++){
            int idx = nums[i]-1;
            arr[idx] = 1;
        }
        List<Integer>ls = new ArrayList<>();

        for(int i=0;i<arr.length;i++){
            if(arr[i] == 0) ls.add(i+1);
        }
           return ls;
    }
}