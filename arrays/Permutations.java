// https://leetcode.com/problems/permutations/
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] b = new boolean[nums.length];
        gen(nums, b, new Stack<Integer>(), res);
        return res;
    }
    
    void gen(int[] nums, boolean[] visited, Stack<Integer> acc, List<List<Integer>> res) {
        if (acc.size() == nums.length) {
            res.add(new ArrayList<>(acc));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                acc.push(nums[i]);
                gen(nums, visited, acc, res);
                acc.pop();
                visited[i] = false;
            }
        }
    }
}