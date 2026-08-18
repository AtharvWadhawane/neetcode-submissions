class Solution {
    static int setBits(int num){
        int setcount = 0;
        while(num > 0){
            num = num & (num-1);
            setcount++;
        }
        return setcount;
    }
    public int[] countBits(int n) {
        int[]result = new int[n+1];

        for(int i=0;i<=n;i++){
            result[i] = setBits(i);
        }

        return result;
    }
}
