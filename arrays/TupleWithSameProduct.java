// https://leetcode.com/problems/tuple-with-same-product
class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        int count = 0;
        for (int x: nums) {
            for (int y: nums) {
                if (x != y) {
                    int p = x * y;
                    freq.put(p, freq.getOrDefault(p, 0) + 1);
                }
            }
        }

        for (int x: freq.values()) {
            count += x * (x - 2);
        }

        return count;
    }
}