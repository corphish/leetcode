// https://leetcode.com/problems/insert-delete-getrandom-o1
class RandomizedSet {
    
    // This is truly O(1) solution
    // What we do is we maintain a stack from which we are going to actually read a random index.
    // Since the stack we are going to maintain is an array, we get O(1) read
    // When we insert, we push the value to stack, and store its index in a map. This is O(1).
    // While removing, we get the index of the value to be removed from the map.
    // What we also do is we pop the top element, and put the top element in the index of the value we are removing, we also update the
    // new index of the top element in map.
    
    int top = 0;
    Map<Integer, Integer> indexes;
    int[] stack;

    public RandomizedSet() {
        indexes = new HashMap<>();
        stack = new int[200001];
    }
    
    public boolean insert(int val) {
        if (indexes.containsKey(val)) {
            return false;
        }
        
        stack[top] = val;
        indexes.put(val, top);
        top = top + 1;
        
        return true;
    }
    
    public boolean remove(int val) {
        if (!indexes.containsKey(val)) {
            return false;
        }
        
        // Get the index of the element to be removed
        int ix = indexes.get(val);
        
        // Pop the top element and put it into this index
        int topElement = stack[top - 1];
        stack[ix] = topElement;
        indexes.put(topElement, ix);
        indexes.remove(val);
        top = top - 1;
        
        return true;
    }
    
    public int getRandom() {
        return stack[(int) (Math.random() * top)];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */