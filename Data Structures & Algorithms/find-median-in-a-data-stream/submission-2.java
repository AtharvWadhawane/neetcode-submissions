class MedianFinder {

    PriorityQueue<Integer>maxheap; //smaller elements 
    PriorityQueue<Integer>minheap; //larger elements

    public MedianFinder() {
        maxheap = new PriorityQueue<>(Collections.reverseOrder());
        minheap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        maxheap.offer(num);

        minheap.offer(maxheap.poll());

        if(minheap.size() > maxheap.size()){
            maxheap.offer(minheap.poll());
        }
    }
    
    public double findMedian() {
        if(maxheap.size() > minheap.size()){ //odd
            return maxheap.peek();
        }else{ //even
            return (maxheap.peek() + minheap.peek())/2.0;
        }
    }
}
