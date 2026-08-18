class Solution {
    public int reverseBits(int n) {
        int rev = 0;

        for(int i=0;i<32;i++){ // runs 32times for 32bits
            
            //make space in result
            rev <<= 1; //left shift by 1

            //add the LSB to result 
            rev = (rev | (n&1)); //to get LSB do bitmasking with &

            n >>= 1; // decrease the number by 1
        }
        return rev;
    }
}