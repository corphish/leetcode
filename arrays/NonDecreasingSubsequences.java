// https://leetcode.com/problems/non-decreasing-subsequences/
class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        fill(nums, 0, new Stack<>(), res, new HashSet<>());
        return res;
    }

    void fill(int[] nums, int i, Stack<Integer> store, List<List<Integer>> res, Set<String> set) {
        if (store.size() > 1) {
            if (set.add(store.toString()))
                res.add(new ArrayList<>(store));
        }

        for (int j = i; j < nums.length; j++) {
            if (store.isEmpty() || nums[j] >= store.peek()) {
                store.push(nums[j]);
                fill(nums, j + 1, store, res, set);
                store.pop();
            }
        }
    }
}