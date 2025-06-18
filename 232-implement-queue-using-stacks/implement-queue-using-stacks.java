class MyQueue {
    Stack <Integer> inStack;
    Stack <Integer> outStack;
    public MyQueue() {
        inStack=new Stack<>();
        outStack=new Stack<>();
    }
    
    public void push(int x) {
        //inStack is used to push elements
        inStack.push(x);
    }
    //first shift the element
    void shiftElements(){
        if(outStack.isEmpty()){
            while(!inStack.isEmpty())
            outStack.push(inStack.pop());
        }
    }
    
    public int pop() {
        shiftElements();
        return outStack.pop();
        
    }
    
    public int peek() {
        shiftElements();
        return outStack.peek();
    }
    
    public boolean empty() {
        return inStack.empty() && outStack.empty();
        
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */