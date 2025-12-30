class MinStack {
    private long min;
    private java.util.Stack<Long> stack;

    public MinStack() {
        stack = new java.util.Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(0L);
            min = val;
        } else {
            stack.push(val - min);
            if (val < min) min = val;
        }
    }

    public void pop() {
        long diff = stack.pop();
        if (diff < 0) min -= diff;
    }

    public int top() {
        long diff = stack.peek();
        return diff > 0 ? (int)(min + diff) : (int)min;
    }

    public int getMin() {
        return (int)min;
    }
}


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */