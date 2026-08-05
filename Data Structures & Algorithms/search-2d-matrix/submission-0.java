class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        //Treat the given 2d mat as 1d arr
        //we will apply binary search as we apply in 1d arr

        //we can convert index to its 2d coordinate

        int row = matrix.length;
        int cols = matrix[0].length;

        int l=0, r = row*cols-1;

        while(l<=r){
            int mid = l+(r-l)/2;;

            //convert index to its 2d coordinate
            int a = mid/cols;
            int b = mid%cols;

            if(matrix[a][b] == target) return true;

            else if(matrix[a][b] > target) r = mid-1;

            else l = mid+1;
        }
        return false;
    }
}
