class Solution {
    public int characterReplacement(String s, int k) {
        int[]freq = new int[26];
        int l = 0, maxcount = 0,result = 0;

        for(int r=0;r<s.length();r++){
            freq[s.charAt(r)-'A']++;

            maxcount = Math.max(maxcount,freq[s.charAt(r)-'A']);

            int windowlen = r-l+1;

            //what if the window is invalid
            while(windowlen-maxcount > k){
                freq[s.charAt(l)-'A']--;
                l++;
                windowlen = r-l+1;
            }
            result = Math.max(result,windowlen);

        }
        return result;
    }
}
