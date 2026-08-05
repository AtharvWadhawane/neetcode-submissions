class Solution {
    public String minWindow(String s, String t) {

       if(s.length()<t.length()) return ""; //edge case

        Map<Character,Integer> need = new HashMap<>();

        for(char c : t.toCharArray()){
            need.put(c,need.getOrDefault(c,0)+1);
        }

        int left = 0, right = 0, start = 0;
        int minlen = Integer.MAX_VALUE;
        int required = need.size();
        int progress = 0;

        Map<Character,Integer>window = new HashMap<>();

        //traversal using right pointer
        while(right<s.length()){
            char curr = s.charAt(right);
            window.put(curr,window.getOrDefault(curr,0)+1);

            if(need.containsKey(curr)){
                if(window.get(curr) == need.get(curr)){
                    progress++;
                }
            }

            while(left<=right && progress == required){
                if(right-left+1<minlen){
                    minlen = right-left+1;
                    start = left;
                }
                //lets shrink the window

                char removechar = s.charAt(left);
                window.put(removechar,window.get(removechar)-1);

                //check if we broke progress and required pact

                if(need.containsKey(removechar) && window.get(removechar) < need.get(removechar)){
                    progress--;
                }
                left++;
            }
            right++;

        }
        return minlen == Integer.MAX_VALUE ? "" : s.substring(start,minlen+start); 

    }
}
