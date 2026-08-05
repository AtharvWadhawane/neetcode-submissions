class Solution {
    public int findMin(int[] arr) {
        int l = 0, r = arr.length-1;

        if(arr[l]<arr[r]) return arr[l]; // array is sorted and not rotated

        while(l<r){
            int mid = l+(r-l)/2;

            if(arr[mid]>arr[r]){ //array is rotated and we move to right
                l = mid+1;
            }
            else r = mid;
        }
        return arr[l]; // our left pointer will be pointing to min element after loop
    }
}
