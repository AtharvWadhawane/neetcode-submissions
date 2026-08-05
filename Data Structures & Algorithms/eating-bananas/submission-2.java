/*
here we will optimze the search for an answer , instead of trying all possible ans
from 1 to n we will use binary search 
*/



class Solution {
    public int getmax(int[]arr){
        int max = 0;
        for(int i=0;i<arr.length;i++) if(arr[i]>max) max = arr[i];

        return max;
    }
      public long calculatetime(int[]arr,int num){

        long sum = 0;
        for(int i=0;i<arr.length;i++){
            sum += (arr[i]+num-1L)/num; // same as  ceil arr[i]/num
        }
        return sum;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int l=1, r = getmax(piles);
        int ans = getmax(piles);

        //BS on Answers
        while(l<=r){
            int mid = l+(r-l)/2;

            long time = calculatetime(piles,mid);

            if(time<=h){
                ans = mid; //possible answer
                //lets find more smaller possible answer
                r = mid-1;
            }
            else l = mid+1;
        }
        return ans;
    }
}
