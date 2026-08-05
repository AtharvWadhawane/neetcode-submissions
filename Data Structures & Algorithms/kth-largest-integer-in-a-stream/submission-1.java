class KthLargest {
        List<Integer>arr;
        int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        arr = new ArrayList();

        for(int i : nums){
            arr.add(i);
        }
    }
    
    public int add(int val) {
        arr.add(val);

        Collections.sort(arr);
        return arr.get(arr.size()-k);
    }
}
