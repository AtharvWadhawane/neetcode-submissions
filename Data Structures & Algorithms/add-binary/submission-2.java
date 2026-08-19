class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sum = new StringBuilder();
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;

        while(i>=0 || j>=0 || carry>0){
            int lsb1 = (i>=0)?a.charAt(i)-'0':0;
            int lsb2 = (j>=0)?b.charAt(j)-'0':0;

            int total = lsb1+lsb2+carry;

            sum.append(total%2);
            carry = total/2;

            i--;
            j--;
        }

        return sum.reverse().toString();
    }
}