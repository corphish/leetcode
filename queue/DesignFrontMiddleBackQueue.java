// https://leetcode.com/problems/design-front-middle-back-queue/
class FrontMiddleBackQueue {

    private Deque<Integer> first, last;

    public FrontMiddleBackQueue() {
        // We have to balance the first and last per operations.
        // Only the first queue is allowed to have just 1 more element at any given time.
        first = new ArrayDeque<>();
        last = new ArrayDeque<>();
    }
    
    public void pushFront(int val) {
        if (first.size() != last.size()) {
            // Move the last element of first queue to the beginning of the last queue.
            int middle = first.removeLast();
            last.addFirst(middle);
        }

        first.addFirst(val);
    }
    
    public void pushMiddle(int val) {
        // If both the queues have same size, prefer the first queue, else balance.
        if (first.size() != last.size()) {
            last.addFirst(first.removeLast());
        }

        first.addLast(val);
    }
    
    public void pushBack(int val) {
        // At the end of this operation we have to make sure that both queues have same size
        if (first.size() == last.size()) {
            // Could be true if both are empty
            if (last.size() == 0) {
                first.add(val);
                return;
            } else {
                int middle = last.removeFirst();
                first.addLast(middle);
            }
        }

        last.addLast(val);
    }
    
    public int popFront() {
        if (first.isEmpty()) {
            return -1;
        }
        int res = first.removeFirst();
        if (first.size() < last.size()) {
            int middle = last.removeFirst();
            first.addLast(middle);
        }
        return res;
    }
    
    public int popMiddle() {
        if (first.isEmpty()) {
            return -1;
        }
        if (first.size() == last.size()) {
            int res = first.removeLast();
            int middle = last.removeFirst();
            first.addLast(middle);
            return res;
        } else {
            return first.removeLast();
        }
    }
    
    public int popBack() {
        if (first.isEmpty()) {
            return -1;
        }
        if (last.size() < first.size()) {
            int middle = first.removeLast();
            last.addFirst(middle);
        }

        return last.removeLast();
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */