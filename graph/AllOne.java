// https://leetcode.com/problems/all-oone-data-structure
class AllOne {
    
    TreeMap<Integer, TreeSet<String>> rev;
    Map<String, Integer> freq;
    
    public AllOne() {
        freq = new HashMap<>();    
        rev = new TreeMap<>();
    }
    
    public void inc(String key) {
        update(key, 1);
        //System.out.println("Incremented " + key + ", rev = " + rev);
    }
    
    public void dec(String key) {
        update(key, -1);
        rev.remove(0);
        //System.out.println("Decremented " + key + ", rev = " + rev);
    }
    
    private void update(String key, int inc) {
        int curr = freq.getOrDefault(key, 0);
        if (curr > 0) {
            TreeSet<String> set = rev.get(curr);
            set.remove(key);
            rev.put(curr, set);
            
            if (set.isEmpty()) {
                rev.remove(curr);
            }
        }
        
        TreeSet<String> newSet = rev.getOrDefault(curr + inc, new TreeSet<>());
        newSet.add(key);
        rev.put(curr + inc, newSet);
        freq.put(key, curr + inc);
    }
    
    public String getMaxKey() {
        //System.out.println("Max");
        if (rev.isEmpty()) return "";
        return rev.lastEntry().getValue().first();
    }
    
    public String getMinKey() {
        //System.out.println("Min");
        if (rev.isEmpty()) return "";
        return rev.firstEntry().getValue().first();
    }
}