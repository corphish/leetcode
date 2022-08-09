class MyCircularQueue {
    
    int front;
    int rear;
    
    int[] circularQueue;
    
    // Total capacity of the queue
    int capacity;
    
    // Size of the queue
    // Becomes easy to track the full or empty state
    int size;
    
    public MyCircularQueue(int k) {
        circularQueue = new int[k];
        capacity = k;
        front = -1;
        rear = -1;
        size = 0;
    }
    
    public boolean enQueue(int value) {
        if (isFull())
            return false;
        
        // Initial condition
        if (front == -1) {
            front++;
        }
        
        rear = (rear + 1) % capacity;
        circularQueue[rear] = value;
        size++;
        
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        } else {
            front = (front + 1) % capacity;
            size--;
            return true;
        }
    }
    
    public int Front() {
        if(isEmpty())
            return -1;
        else {
            return circularQueue[front];
        }
    }
    
    public int Rear() {
        if(isEmpty())
            return -1;
        else {
            return circularQueue[rear];
        }
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */