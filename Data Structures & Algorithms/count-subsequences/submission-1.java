//Memoization Approach (solves exponential overlapping subproblem by noting ans to avoid recompute)

class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length(), m = t.length();
        Integer[][]memo = new Integer[n][m];
        return count(s,t,0,0,memo);
    }
    private static int count(String s,String t,int i,int j,Integer[][]memo){
        //base case 
        if(j == t.length()) return 1; // string matched completely
        if(i == s.length()) return 0; //ran out of string s

        if(memo[i][j] != null) return memo[i][j];

        int ways = 0;
        if(s.charAt(i) == t.charAt(j)){ //matched
            ways += count(s,t,i+1,j+1,memo); //include
        }
        ways += count(s,t,i+1,j,memo); //skip

        return memo[i][j] = ways;
    }
}