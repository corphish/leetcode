// https://leetcode.com/problems/implement-stack-using-queues
class MyStack {
    
    // We will always work with the q1
    Deque<Integer> q1, q2;

    public MyStack() {
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
    }
    
    public void push(int x) {
        q1.addLast(x);
    }
    
    public int pop() {
        // Remove the first n - 1 elements, add them to the other queue.
        // Then remove the only element which would be the result.
        // Now swap the queues to ensure consistent operation
        int n = q1.size();
        for (int i = 1; i < n; i++) {
            int first = q1.removeFirst();
            q2.addLast(first);
        }
        
        int result = q1.removeFirst();
        
        // Swap the queues
        var t = q1;
        q1 = q2;
        q2 = q1;
        
        return result;
    }
    
    public int top() {
        return q1.getLast();
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */