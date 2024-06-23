// https://leetcode.com/problems/subsets/
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] v = new boolean[nums.length];
        
        build(nums, v, 0, new Stack<>(), res);
        return res;
    }
    
    void build(int[] nums, boolean[] visited, int start, Stack<Integer> stack, List<List<Integer>> store) {
        store.add(new ArrayList<>(stack));
        
        for (int i = start; i < nums.length; i++) {
            if (!visited[i]) {
                stack.push(nums[i]);
                visited[i] = true;
                build(nums, visited, i + 1, stack, store);
                visited[i] = false;
                stack.pop();
            }
        }
    }
}