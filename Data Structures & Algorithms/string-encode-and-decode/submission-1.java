class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb  = new StringBuilder();

        for(String s : strs){
            sb.append(s.length()).append('#').append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String>decodedstring = new ArrayList<>();
        
        int currentindex = 0;

        while(currentindex < str.length()){
            int delimiterindex = str.indexOf('#',currentindex);

            int stringlength = Integer.parseInt(str.substring(currentindex,delimiterindex));

            int startindex = delimiterindex + 1;
            int endindex = startindex + stringlength;

            decodedstring.add(str.substring(startindex,endindex));

            currentindex = endindex;
        }
        return decodedstring;
    }
}
