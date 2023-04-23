// https://leetcode.com/problems/single-number-ii/
// Not the optimum solution
class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x: nums) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        for (var e: freq.entrySet()) {
            if (e.getValue() == 1) {
                return e.getKey();
            }
        }

        return 0;
    }
}