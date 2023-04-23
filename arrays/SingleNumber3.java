// https://leetcode.com/problems/single-number-iii/
// Not optimum solution
class Solution {
    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x: nums) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        int[] res = new int[2];
        int i = 0;
        for (var e: freq.entrySet()) {
            if (e.getValue() == 1) {
                res[i++] = e.getKey();
            }
        }

        return res;
    }
}