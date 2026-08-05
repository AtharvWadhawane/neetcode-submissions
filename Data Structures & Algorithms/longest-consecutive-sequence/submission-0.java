class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();

        for(int i : nums){
            hs.add(i);
        }

        int longest = 0,streak = 0;

        for(int i : hs){
            if(!hs.contains(i-1)){
                int current  = i;
                streak = 1;

                while(hs.contains(current+1)){
                    current++;
                    streak++;
                }
            }
            longest = Math.max(longest,streak);
        }
        return longest;

    }
}
