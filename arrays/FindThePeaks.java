// https://leetcode.com/problems/find-the-peaks/
class Solution {
    public List<Integer> findPeaks(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                res.add(i);
            }
        }

        return res;
    }
}