class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        char[] charArrayOne =  s.toCharArray();
        char[] charArrayTwo =  t.toCharArray();
        Arrays.sort(charArrayOne);
        Arrays.sort(charArrayTwo);

        return Arrays.equals(charArrayOne,charArrayTwo);
    }
}
