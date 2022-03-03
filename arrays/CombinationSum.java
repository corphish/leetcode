// https://leetcode.com/problems/combination-sum
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        build(candidates, target, 0, new Stack<>(), res);
        return res;
    }
    
    void build(int[] nums, int target, int start, Stack<Integer> current, List<List<Integer>> store) {
        if (target == 0) {
            store.add(new ArrayList<>(current));
            return;
        }
        
        if (target < 0) return;
        
        for (int i = start; i < nums.length; i++) {
            if (nums[i] <= target) {
                current.push(nums[i]);
                build(nums, target - nums[i], i, current, store);
                current.pop();
            }
        }
    }
}