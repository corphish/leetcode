// https://leetcode.com/problems/random-pick-index/
class Solution {
    
    Map<Integer, IndexTracker> map = new HashMap<>();

    public Solution(int[] nums) {
        int i = 0;
        for (int x: nums) {
            IndexTracker it = map.getOrDefault(x, new IndexTracker());
            it.add(i);
            map.put(x, it);
            i++;
        }
    }
    
    public int pick(int target) {
        return map.get(target).get();
    }
    
    class IndexTracker {
        List<Integer> indexes;
        int curr;
        
        IndexTracker() {
            indexes = new ArrayList<>();
            curr = 0;
        }
        
        void add(int index) {
            indexes.add(index);
        }
        
        int get() {
            int ret = indexes.get(curr);
            curr = (curr + 1) % indexes.size();
            
            return ret;
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */