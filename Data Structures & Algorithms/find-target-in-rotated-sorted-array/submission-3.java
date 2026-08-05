class Solution {
    public int search(int[] arr, int target) {
        int l = 0, r = arr.length-1;

        while(l<=r){
            int mid = l+(r-l)/2;

            if(arr[mid] == target) return mid;

            //Identify the sorted Half

            if(arr[l]<=arr[mid]){ //left half is sorted

                //check if our target exists in this sorted half or not
                if(arr[l]<=target && target<=arr[mid]) r = mid-1;

                else l = mid+1; // it is not in this half
            }
            else{ //right half is sorted
                    if(arr[mid]<=target && target<=arr[r]) l = mid+1;

                    else r = mid-1;
            }
        }
        return -1;
    }
}
