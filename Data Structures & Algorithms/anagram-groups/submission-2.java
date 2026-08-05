class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>>map = new HashMap<>();

        for(String word : strs){
            char[]c = word.toCharArray();
            Arrays.sort(c);
            String key = new String(c);

            map.computeIfAbsent(key, k-> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(map.values());
    }
}
