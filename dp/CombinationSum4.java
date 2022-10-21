// https://leetcode.com/problems/combination-sum-iv
class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] store = new int[target + 1];
        Arrays.fill(store, -1);
        return combo(nums, target, store);
    }
    
    int combo(int[] nums, int target, int[] store) {
        if (target == 0) {
            return 1;
        }
        
        if (store[target] >= 0) {
            return store[target];
        }
        
        int count = 0;
        for (int x: nums) {
            if (x <= target) {
                count += combo(nums, target - x, store);
            }
        }
        
        store[target] = count;
        
        return count;
    }
}