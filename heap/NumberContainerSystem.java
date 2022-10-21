// https://leetcode.com/problems/design-a-number-container-system
class NumberContainers {
    
    Map<Integer, Integer> indexMap;
    Map<Integer, TreeSet<Integer>> revMap;

    public NumberContainers() {
        indexMap = new HashMap<>();
        revMap = new HashMap<>();
    }
    
    public void change(int index, int number) {
        Integer prev = indexMap.get(index);
        if (prev != null) {
            TreeSet<Integer> prevSet = revMap.get(prev);
            if (prevSet != null) {
                prevSet.remove(index);
                revMap.put(prev, prevSet);
            }
        }
        
        indexMap.put(index, number);
        revMap.computeIfAbsent(number, x -> new TreeSet<>()).add(index);
    }
    
    public int find(int number) {
        TreeSet<Integer> set = revMap.get(number);
        return set == null || set.isEmpty() ? -1 : set.first();
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */