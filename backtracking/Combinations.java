// https://leetcode.com/problems/combinations
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        gen(n, k, 1, new ArrayDeque<>(), res);
        return res;
    }
    
    void gen(int n, int k, int start, Deque<Integer> store, List<List<Integer>> res) {
        // If the store size is k, we have a combination
        if (store.size() == k) {
            res.add(new ArrayList<>(store));
            return;
        }
        
        
        // Starting from start, generate a combo
        for (int i = start; i <= n; i++) {
            store.addLast(i);
            gen(n, k, i + 1, store, res);
            store.removeLast();
        }
    }                                                                               
}