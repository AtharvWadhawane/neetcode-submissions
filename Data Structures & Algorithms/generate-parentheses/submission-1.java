class Solution {
    public List<String> generateParenthesis(int n) {
        List<String>result = new ArrayList<>();
        backtrack(result,"",n,0,0);
        return result;
    }

   private void  backtrack(List<String>result, String sb, int n, int opencount,int closecount){
        if(sb.length() == 2*n){
            result.add(sb.toString());
            return;
        }       

        if(opencount < n){
            backtrack(result,sb + '(',n,opencount+1,closecount);
        }

        if(closecount < opencount){
            backtrack(result,sb + ')',n,opencount,closecount+1);
        }
    }
}