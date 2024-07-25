// https://leetcode.com/problems/132-pattern/
class Solution {
    public boolean find132pattern(int[] nums) {
        TreeMap<Integer, Integer> left = new TreeMap<>();
        TreeMap<Integer, Integer> right = new TreeMap<>();

        for (int x : nums) {
            right.put(x, right.getOrDefault(x, 0) + 1);
        }

        for (int x : nums) {
            // Remove x from right
            int freq = right.get(x);
            if (freq == 1) {
                right.remove(x);
            } else {
                right.put(x, freq - 1);
            }

            if (left.size() == 0) {
                left.put(x, 1);
                continue;
            } else {
                // Check the first key
                int firstInLeft = left.firstKey();
                if (firstInLeft < x) {
                    // We have 1 and 3, search for 2
                    Integer twoInRight = right.higherKey(firstInLeft);
                    if (twoInRight == null || twoInRight >= x) {
                        left.put(x, left.getOrDefault(x, 0) + 1);
                    } else {
                        return true;
                    }

                } else {
                    left.put(x, left.getOrDefault(x, 0) + 1);
                }
            }
        }

        return false;
    }
}