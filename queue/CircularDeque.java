// https://leetcode.com/problems/design-circular-deque/
// Looks same as normal circular queue
class MyCircularDeque {

    private int[] deque;
    private int size, maxSize, front, rear;
    
    public MyCircularDeque(int k) {
        deque = new int[k];
        size = 0;
        maxSize = k;
        front = 0;
        rear = k - 1;
    }
    
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        
        // Important thing to notice
        front = (maxSize + front - 1) % maxSize;
        deque[front] = value;
        size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        rear = (rear + 1) % maxSize;
        deque[rear] = value;
        size++;
        return true;
    }
    
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % maxSize;
        size--;
        return true;
    }
    
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        
        // Important thing to notice
        rear = (maxSize + rear - 1) % maxSize;
        size--;
        return true;
    }
    
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return deque[front];
    }
    
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return deque[rear];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == maxSize;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */