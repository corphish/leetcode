// https://leetcode.com/problems/subsets-ii
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        build(nums, 0, new Stack<>(), set);
        return set.stream().collect(Collectors.toList());
    }

    void build(int[] nums, int i, Stack<Integer> path, Set<List<Integer>> store) {
        store.add(new ArrayList<>(path));
        if (i >= nums.length) return;

        // Dont choose i
        build(nums, i + 1, path, store);

        // Choose i
        path.push(nums[i]);
        build(nums, i + 1, path, store);
        path.pop();
    }
}