class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int size = temperatures.length;
        int[]result = new int[size];
        ArrayDeque<Integer> st = new ArrayDeque<>();

        for(int i=0;i<size;i++){
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
                int previndx = st.pop();
                result[previndx] = i - previndx;
            }
            st.push(i);
        }
        return result;
    }
}
