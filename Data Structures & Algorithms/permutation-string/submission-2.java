class Solution {
    public boolean checkInclusion(String s1, String s2) {

        //edge case 
        if(s1.length()>s2.length()) return false;
        int[]s1freq = new int[26];
        int[]windowfreq = new int[26];

        for(char c : s1.toCharArray()){
            s1freq[c - 'a']++;
        }

        //initial window 
        for(int i=0;i<s1.length();i++){
            windowfreq[s2.charAt(i) - 'a']++;
        }
        //first check 
        if(isEqual(s1freq,windowfreq)) return true;

        //check window
        for(int i=s1.length();i<s2.length();i++){
            windowfreq[s2.charAt(i) - 'a']++;
            windowfreq[s2.charAt(i-s1.length()) - 'a']--;

            if(isEqual(s1freq,windowfreq)) return true;
        }
        return false;
    }
    private static boolean isEqual(int[]s,int[]b){
        for(int i=0;i<26;i++){
            if(s[i]!=b[i]) return false;
        }
        return true;
    }
}