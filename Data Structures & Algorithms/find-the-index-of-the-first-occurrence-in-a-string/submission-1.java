//brute force 

class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length() < needle.length()) return -1;
        int k = 0;
        for(int i=0;i<haystack.length();i++){
            int count = 0;
            for(int j=i;j<haystack.length();j++){
                if(needle.charAt(k++) == haystack.charAt(j)){
                    count++;
                    if(count == needle.length()) return i;
                }else {
                k = 0;
                break;
                }
            }
        }
        return -1;
    }
}