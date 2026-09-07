class Solution {
    public String gcdOfStrings(String str1, String str2) {

        if((str1+str2).equals(str2+str1)){ //base string exists
            int a = str1.length();
            int b = str2.length();

            int gcd = findGcd(a,b);

            return str1.substring(0,gcd);
        } 
        return "";
    }

    private static int findGcd(int a,int b){
        if(b == 0) return a;

        return findGcd(b,a%b);
    }
}