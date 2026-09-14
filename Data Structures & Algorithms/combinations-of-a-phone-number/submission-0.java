class Solution {
    public List<String> letterCombinations(String digits) {

        
        int len = digits.length();
        List<String>result = new ArrayList<>();
        StringBuilder temp = new StringBuilder();

        if(digits.length() == 0) return result;

        HashMap<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        backtrack(map,result,temp,digits,len,0);

        return result;
    }

    private void backtrack(HashMap<Character,String>map,List<String>result,StringBuilder temp,String input,int size,int idx){

        //Base case
        if(idx == size){
            result.add(temp.toString());
            return;
        }

        String choice = map.get(input.charAt(idx));

        for(int k=0;k<choice.length();k++){
            temp.append(choice.charAt(k)); // pick

            backtrack(map,result,temp,input,size,idx+1); // next stage

            temp.deleteCharAt(temp.length()-1); // undo
        }
    }
}