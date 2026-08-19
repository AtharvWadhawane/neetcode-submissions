class Solution {
    public int missingNumber(int[] arr) {
        int n = arr.length;
        int Expected = (n*(n+1))/2;
        int real = 0;
        for(int i : arr){
            real += i;
        }
        return Expected-real;
    }
}