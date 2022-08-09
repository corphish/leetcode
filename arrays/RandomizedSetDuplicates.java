// https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed
class RandomizedCollection {
    
    // This is O(1) read, but O(log(n)) insert and remove.
    // What we do is we maintain a stack from which we are going to actually read a random index.
    // Since the stack we are going to maintain is an array, we get O(1) read
    // When we insert, we push the value to stack, and store its index in a map, which stores it in a set to maintain ordering. This is O(1).
    // While removing, we get the index of the value to be removed from the map.
    // What we also do if the value to be deleted is not equal to top element, is we pop the top element, and put the top element in the index of the value we are removing, we also update the new index of the top element in map.
    
    int top = 0;
    Map<Integer, TreeSet<Integer>> indexes;
    int[] stack;

    public RandomizedCollection() {
        indexes = new HashMap<>();
        stack = new int[200001];
    }
    
    public boolean insert(int val) {
        boolean ret = !indexes.containsKey(val);
        
        stack[top] = val;
        
        TreeSet<Integer> st = indexes.getOrDefault(val, new TreeSet<>());
        st.add(top);
        indexes.put(val, st);
        
        top = top + 1;
        
        return ret;
    }
    
    public boolean remove(int val) {
        if (!indexes.containsKey(val)) {
            return false;
        }
        
        // Get the index of the element to be removed
        TreeSet<Integer> rem = indexes.get(val);
        int ix = rem.pollLast();
        
        // Pop the top element and put it into this index
        int topElement = stack[top - 1];
        stack[ix] = topElement;
        
        // If only the top element is not same as that of what we are deleting
        // we adjust the stack by popping its top element and putting it in the deletion index.
        if (val != topElement) {
            TreeSet<Integer> ins = indexes.get(topElement); // Should not be null
            // We pop the top index
            ins.pollLast();

            // We push
            ins.add(ix);
            indexes.put(topElement, ins);
        }

            
        if (rem.isEmpty()) {
            indexes.remove(val);
        } else {
            indexes.put(val, rem);
        }

        top = top - 1;
        
        //System.out.println(indexes);
        
        return true;
    }
    
    public int getRandom() {
        return stack[(int) (Math.random() * top)];
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */