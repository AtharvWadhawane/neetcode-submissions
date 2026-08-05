class Solution {
    public boolean checkInclusion(String s1, String s2) {
       int[]s1freq = new int[26];

       for(char c : s1.toCharArray()){
            s1freq[c - 'a']++;
       }
       // int windowsize = s1.length();  extra variable for understanding 

       for(int i=0;i<s2.length();i++){
        int winidx = 0, curridx = i;

        int[]winfreq = new int[26];

        //update winfreq with valid windows
        while(winidx < s1.length() && curridx < s2.length()){
            winfreq[s2.charAt(curridx) - 'a']++;
            winidx++; curridx++;
        }
        if(isEqualFreq(s1freq,winfreq)) return true;
       }
       return false;
    }
    private static boolean isEqualFreq(int[]fa, int[]fb){
        for(int i=0;i<26;i++){
            if(fa[i] != fb[i]) return false;
        }
        return true;
    }
}
