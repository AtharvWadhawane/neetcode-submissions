class Solution {
    public int lengthOfLastWord(String s) {
        int ans = 0;
        int i = s.length()-1;

        //remove initial spaces from end
        while(i>=0 && s.charAt(i) == ' ') i--;

        //now count the word length

        while(i>=0 && s.charAt(i) != ' '){
            ans++;
            i--;
        }
        return ans;
    }
}