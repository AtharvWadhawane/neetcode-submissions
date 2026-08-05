class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        boolean[]visited = new boolean[strs.length];

        for(int i=0;i<strs.length;i++){
            if(visited[i]) continue;

            List<String> ls = new ArrayList<>();
            ls.add(strs[i]);
            visited[i] = true;

            for(int j=i+1;j<strs.length;j++){
                if(!visited[j] && checkAnagram(strs[i],strs[j])){
                    ls.add(strs[j]);
                    visited[j] = true;
                }
            }
            result.add(ls);
        }
        return result;
    }
    public boolean checkAnagram(String s1,String s2){

        if(s1.length()!=s2.length())return false;
        int[]alpha = new int[26];
        Arrays.fill(alpha,0);

        for(int i=0;i<s1.length();i++){
            alpha[s1.charAt(i) - 'a']++; 
            alpha[s2.charAt(i) - 'a']--; 
        }
        for(int i:alpha){
            if(i!=0) return false;
        }
        return true;
    }
}
