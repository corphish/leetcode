// https://leetcode.com/problems/design-a-stack-with-increment-operation
class CustomStack {
    // Normal stack with O(k) increment
    int[] stack;
    int top;
    int n;

    public CustomStack(int maxSize) {
        n = maxSize;
        stack = new int[maxSize];
    }
    
    public void push(int x) {
        if (top < n)
            stack[top++] = x;
    }
    
    public int pop() {
        if (top == 0) return -1;
        return stack[--top];
    }
    
    public void increment(int k, int val) {
        for (int i = 0; i < Math.min(n, k); i++) {
            stack[i] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */