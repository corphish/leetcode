// https://leetcode.com/problems/design-bitset
class Bitset {
    int size;
    int sum = 0;
    boolean isFlipped;
    Set<Integer> oneIndexes;

    public Bitset(int size) {
        this.size = size;
        oneIndexes = new HashSet<>();
    }
    
    public void fix(int idx) {
        setOrUnset(idx, !isFlipped);
    }
    
    public void unfix(int idx) {
        setOrUnset(idx, isFlipped);
    }
    
    private void setOrUnset(int idx, boolean condition) {
        if (condition) {
            oneIndexes.add(idx);
        } else {
            oneIndexes.remove(idx);
        }
        
        //System.out.println("Ones=" + oneIndexes + ", flipped=" + isFlipped);
    }
    
    public void flip() {
        isFlipped = !isFlipped;
    }
    
    private int computeSum() {
        int ones = oneIndexes.size();
        if (isFlipped) {
            ones = size - ones;
        }
        
        return ones;
    }
    
    public boolean all() {
        return computeSum() == size;
    }
    
    public boolean one() {
        return computeSum() > 0;
    }
    
    public int count() {
        return computeSum();
    }
    
    public String toString() {
        char[] res = new char[size];
        Arrays.fill(res, isFlipped ? '1' : '0');
        for (int x: oneIndexes) {
            res[x] = isFlipped ? '0' : '1';
        }
        
        return new String(res);
    }
}