class MinStack {
    private Stack<Integer> mSt ;
    private Stack<Integer> minSt;
    public MinStack() {
        mSt = new Stack<>();
        minSt = new Stack();
    }
    
    public void push(int val) {
        mSt.push(val);
        if(minSt.isEmpty()){
            minSt.push(val);
        } else{
            int p = minSt.peek();
            if(p <= val){
                minSt.push(p);
            } else{
                minSt.push(val);
            }
        }
    }
    
    public void pop() {
        mSt.pop();
        minSt.pop();
    }
    
    public int top() {
        return mSt.peek();
    }
    
    public int getMin() {
        return minSt.peek();
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