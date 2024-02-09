// https://leetcode.com/problems/largest-divisible-subset
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<Map<Integer, List<Integer>>> memo = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            memo.add(new HashMap<>());
        }

        return check(nums, 0, 1, memo);
    }

    List<Integer> check(
        int[] nums, 
        int i, int last,
        List<Map<Integer, List<Integer>>> memo
    ) {
        if (i >= nums.length) {
            return new ArrayList<>();
        }

        if (memo.get(i).containsKey(last)) {
            return memo.get(i).get(last);
        }

        List<Integer> res = new LinkedList<>();

        if (nums[i] % last == 0) {
            res.add(nums[i]);
            res.addAll(check(nums, i + 1, nums[i], memo));
        }

        List<Integer> other = check(nums, i + 1, last, memo);
        List<Integer> ret = res.size() > other.size() ? res : other;
        memo.get(i).put(last, ret);
        return ret;
    }
}