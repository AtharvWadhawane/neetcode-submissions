class Solution {
    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder();

        Stack<Pair>stack = new Stack<>(); // character and count

        for(char c : s.toCharArray()){
            if(!stack.isEmpty() && stack.peek().ch == c){
                stack.peek().count++;
                if(stack.peek().count == k) stack.pop();
            }
            else{
                stack.push(new Pair(c,1));
            }
        }

        for(Pair p : stack){
            while(p.count-- > 0){
                sb.append(p.ch);
            }
        }
        return sb.toString();

    }
}
class Pair{
    char ch;
    int count;

    Pair(char ch, int count){
        this.ch = ch;
        this.count = count;
    }
}