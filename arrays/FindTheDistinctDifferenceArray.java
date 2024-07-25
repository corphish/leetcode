// https://leetcode.com/problems/find-the-distinct-difference-array/
class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            Set<Integer> pre = new HashSet<>();
            Set<Integer> suf = new HashSet<>();

            for (int j = 0; j <= i; j++) {
                pre.add(nums[j]);
            }

            for (int j = i + 1; j < n; j++) {
                suf.add(nums[j]);
            }

            res[i] = pre.size() - suf.size();
        }

        return res;
    }
}