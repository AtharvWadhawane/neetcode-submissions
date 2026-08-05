// Time complexity = O(n log k)

// Space = O(k) 


class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][]result = new int[k][2];

        PriorityQueue<int[]>maxheap = new PriorityQueue<>(
            (x, y) -> Integer.compare(
                         y[0]*y[0] + y[1]*y[1],
                         x[0]*x[0] + x[1]*x[1]
                        )
        );

        for(int [] i : points){
            maxheap.offer(i);

            if(maxheap.size() > k) maxheap.poll();
        }

        for(int i=k-1;i>=0;i--){
            result[i] = maxheap.poll();
        }
        return result;
    }
}
