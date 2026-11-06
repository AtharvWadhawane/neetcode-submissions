//Memo

class Solution {
    int[][]dp;

    public int minCost(int n, int[] cuts) {
        //we need to add boundaries to cuts
        int c = cuts.length;

        int[]bound = new int[c+2];
        bound[0] = 0;

        for(int i=0;i<c;i++){
            bound[i+1] = cuts[i];
        }

        bound[bound.length-1] = n;

        Arrays.sort(bound);

        dp = new int[c+2][c+2];

        for(int[]row : dp) Arrays.fill(row,-1);

        return find(bound,1,bound.length-2);
    }

    private int find(int[]cuts,int i,int j){
        if(i > j) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int ans = Integer.MAX_VALUE;

        for(int idx = i; idx<=j; idx++){
            int cost = cuts[j+1] - cuts[i-1];

            int temp = cost + find(cuts,i,idx-1) + find(cuts,idx+1,j);

            ans = Math.min(ans,temp);
        }

        return dp[i][j] = ans;
    }
}