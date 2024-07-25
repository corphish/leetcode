// https://leetcode.com/problems/minimum-average-of-smallest-and-largest-elements/submissions/1317355156/
class Solution {
    public double minimumAverage(int[] nums) {
        TreeSet<Double> set = new TreeSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            set.add((nums[i] * 1.0 + nums[nums.length - 1 - i]) / 2);
        }

        return set.first();
    }
}