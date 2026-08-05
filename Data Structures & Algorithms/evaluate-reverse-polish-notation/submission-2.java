class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> st = new ArrayDeque<>();

        for (String c : tokens) {
            switch (c) {
                case "+" -> st.push(st.pop() + st.pop());
                case "-" -> {
                    int a = st.pop();
                    int b = st.pop();
                    st.push(b - a);
                }
                case "*" -> st.push(st.pop() * st.pop());
                case "/" -> {
                    int a = st.pop();
                    int b = st.pop();
                    st.push(b / a);
                }
                default -> st.push(Integer.parseInt(c));
            }
        }
        return st.pop();
    }
}
