class MedianFinder {
    List<Integer> ls;

    public MedianFinder() {
        ls = new ArrayList<>();
    }
    
    public void addNum(int num) {
        ls.add(num);
    }
    
    public double findMedian() {
        Collections.sort(ls);
        if(ls.size()%2 != 0){ //odd length
            int mid = ls.size()/2;
            return (double)ls.get(mid);
        }else{ //even
            return (double) (ls.get(ls.size()/2) + ls.get(ls.size()/2-1))/2;

        }
    }
}
