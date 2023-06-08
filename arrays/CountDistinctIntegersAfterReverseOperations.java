// https://leetcode.com/problems/count-number-of-distinct-integers-after-reverse-operations
class Solution {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x: nums) {
            set.add(x);
            int r = 0;
            while (x > 0) {
                r = r * 10 + (x % 10);
                x /= 10;
            }
            set.add(r);
        }

        return set.size();
    }
}