
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result,new StringBuffer(),n,0,0);
        return result;
    }

    private void backtrack(List<String>result,StringBuffer sb, int n,
    int open_count, int close_count){

        //add to result
        if(sb.length() == 2*n){
            result.add(sb.toString());
            return;
        }

        //add open
        if(open_count < n){
            sb.append('(');
            backtrack(result,sb,n,open_count+1,close_count);
            sb.deleteCharAt(sb.length()-1); //this method deletes at a given index 
        }

        if(close_count < open_count){
            sb.append(')');
            backtrack(result,sb,n,open_count,close_count+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
