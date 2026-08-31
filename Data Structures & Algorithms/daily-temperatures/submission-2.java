class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[]result = new int[n];

        Deque<Integer>st = new ArrayDeque<>();

        for(int i=n-1;i>=0;i--){

            //when to pop
            while(!st.isEmpty() && temperatures[st.peek()] <= temperatures[i]){
                st.pop();
            }
            //save ans
            result[i] = st.isEmpty() ? 0 : st.peek() - i;

            //push current , potential ans
            st.push(i);
        }
        return result;
    }
}