class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()) return "";

        int[]targetFreq = new int[128];
        for(char c : t.toCharArray()){
            targetFreq[c]++;
        }
        int start = 0, left = 0, right = 0, count = 0;

        int minlen = Integer.MAX_VALUE;

        int[]windowFreq = new int[128];

        while(right < s.length()){
            char c = s.charAt(right);
            windowFreq[c]++;

            //check if this character is needed
            if(targetFreq[c] > 0 && windowFreq[c] <= targetFreq[c]) count++;

            while(count == t.length()){
                if(right-left+1 < minlen){
                    minlen = right-left+1;
                    start = left;
                }

                //shrink the window from left
                char leftchar = s.charAt(left);
                windowFreq[leftchar]--;

                if(targetFreq[leftchar] > 0 && windowFreq[leftchar] < targetFreq[leftchar]){
                    count--;
                }
                left++;
            }
            right++;
        }

        return minlen == Integer.MAX_VALUE ? "" : s.substring(start,start+minlen);
    }
}