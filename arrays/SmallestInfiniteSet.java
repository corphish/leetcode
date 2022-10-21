// https://leetcode.com/problems/smallest-number-in-infinite-set
class SmallestInfiniteSet {
    
    int min = 1;
    Set<Integer> popped = new HashSet<>();

    public SmallestInfiniteSet() {
        
    }
    
    public int popSmallest() {
        while (popped.contains(min)) {
            min++;
        }
        
        popped.add(min);
        return min;
    }
    
    public void addBack(int num) {
        if (popped.contains(num)) {
            popped.remove(num);
        }
        
        min = Math.min(min, num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */