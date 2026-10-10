class Solution {
    public int climbStairs(int n) {
        if(n == 1)return 1;
        int[]memo = new int[n+1];

        return recurse(0,n,memo);
    }

    private int recurse(int i,int n,int[]memo){
        if(i == n) return 1;
        if(i > n) return 0;

        if(memo[i]!=0) return memo[i];

        memo[i] = recurse(i+1,n,memo) + recurse(i+2,n,memo);

        return memo[i];
    }
}