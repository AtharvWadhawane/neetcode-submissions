class Solution {
    public int lengthOfLastWord(String s) {

    if(s.length() == 1) return 1;
     StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String s1 = sb.toString();

        char []c = s1.toCharArray();

        int i = 0;

        while(true){
            if(c[i] == ' ') i++;
            else break;
        }

        for(int j=i;j<c.length;j++){

            if(c[j] == ' ') return j-i;
        }
        return -1;


    }
}