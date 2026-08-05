class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        //Brute Force 
        int size =temperatures.length;
        int idx = 0;
        int result[] = new int[size];

        for(int l=0;l<size-1;l++){
            for(int r=l+1;r<size;r++){
                if(temperatures[l]<temperatures[r]){
                    result[idx++] = r-l;
                    break;
                }
            }
            if(idx == l) idx++;
        }

        return result;
    }
}
