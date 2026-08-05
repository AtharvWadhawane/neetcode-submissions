class Solution {
    public int lengthOfLastWord(String s) {
         StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String s1 = sb.toString();

        char []c = s1.toCharArray();
        int count = 0;
        for(int j=0;j<c.length;j++){

            if(c[j] == ' '){
                count++;
            }
            else break;
        }
        int ans = 0;
        for(int i=count;i<c.length;i++){
            if(c[i] != ' ')ans++;
            else break;
        }

        return ans;
    }
}