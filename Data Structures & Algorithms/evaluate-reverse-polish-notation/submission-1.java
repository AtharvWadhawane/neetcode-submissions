class Solution {
    public int evalRPN(String[] tokens) {
       Stack<Integer> st = new Stack<>();

        for (String c : tokens) {
            switch (c) {
                case "+":
                    st.push(st.pop() + st.pop());
                    break;
                case "-":
                    int b = st.pop();
                    int a = st.pop();
                    st.push(a - b);
                    break;
                case "*":
                    st.push(st.pop() * st.pop());
                    break;
                case "/":
                    b = st.pop();
                    a = st.pop();
                    st.push(a / b); // integer division
                    break;
                default:
                    st.push(Integer.parseInt(c));
            }
        }
        return st.pop();

    }
}
