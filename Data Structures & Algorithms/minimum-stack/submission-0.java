class MinStack {
    Stack<Integer> mainst = new Stack<>();
    Stack<Integer> minst = new Stack<>();
    public MinStack() {
    }
    
    public void push(int val) {
        mainst.push(val);

        if(minst.isEmpty() || val <= minst.peek()){
            minst.push(val);
        }
    }
    
    public void pop() {
        if(mainst.isEmpty()) return;

        int popped = mainst.pop();

        if(popped == minst.peek()){
            minst.pop();
        }
    }
    
    public int top() {
        return mainst.peek();
    }
    
    public int getMin() {
         return minst.peek();
    }
}
