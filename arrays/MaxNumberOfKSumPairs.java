// https://leetcode.com/problems/max-number-of-k-sum-pairs
class Solution {
    public int maxOperations(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> freq = new HashMap<>();

        for (int x: nums) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        for (int x: nums) {
            int target = k - x;
            if (freq.containsKey(target) && freq.containsKey(x)) {
                if (x != target || (x == target && freq.get(x) > 1)) 
                    count += 1;
                freq.put(x, freq.get(x) - 1);
                freq.put(target, freq.get(target) - 1);

                if (freq.get(x) == 0) {
                    freq.remove(x);
                }

                if (freq.containsKey(target) && freq.get(target) == 0) {
                    freq.remove(target);
                }
            }
        }

        return count;
    }
}