//brute force :
/*
we know the max element will always be an answer

so our range of answer is from 1 to max element
loop through 1 to max element
and find if it satisfies the condition or not in given amount of time 
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
        int maxz = getmax(piles);

        for(int i=1;i<=maxz;i++){
            long totaltime = calculatetime(piles,i);

            if(totaltime<=h) return i;
        }
        return -1;
    }
}
