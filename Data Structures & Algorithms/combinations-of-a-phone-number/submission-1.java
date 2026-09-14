class Solution {
    Map<Character, String> map;

    public List<String> letterCombinations(String digits) {

        
        int len = digits.length();
        List<String>result = new ArrayList<>();
        StringBuilder temp = new StringBuilder();

        if(digits.length() == 0) return result;

        map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        backtrack(result,temp,digits,0);

        return result;
    }

    private void backtrack(List<String>result,StringBuilder temp,String input,int idx){

        //Base case
        if(idx == input.length()){
            result.add(temp.toString());
            return;
        }

        String choice = map.get(input.charAt(idx));

        for(int k=0;k<choice.length();k++){
            temp.append(choice.charAt(k)); // pick

            backtrack(result,temp,input,idx+1); // next stage

            temp.deleteCharAt(temp.length()-1); // undo
        }
    }
}