//Tabulation (With Space-Optimization)

class Solution {
    public int climbStairs(int n) {
        if(n == 1)return 1;

        int prev = 1;
        int before_prev = 1;

        for(int i=2;i<=n;i++){
            int ans = prev + before_prev;
            before_prev = prev;
            prev = ans;
        }

        return prev;
    }
}