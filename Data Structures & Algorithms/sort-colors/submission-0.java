class Solution {
    private static void swap(int[] arr,int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    public void sortColors(int[] arr) {
        int left = 0, mid = 0, right = arr.length-1;

        while(mid<=right){
            
            if(arr[mid] == 0){
                swap(arr,mid,left);
                mid++;
                left++;
            }
            else if(arr[mid] == 1){
                mid++;
            }
            else{
                swap(arr,mid,right);
                right--;
            }
        }
        System.out.print(Arrays.toString(arr));
    }
}