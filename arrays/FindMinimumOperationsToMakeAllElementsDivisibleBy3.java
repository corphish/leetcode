// https://leetcode.com/problems/find-minimum-operations-to-make-all-elements-divisible-by-three/
class Solution {
    public int minimumOperations(int[] nums) {
        int count = 0;
        for (int x: nums) {
            if (x % 3 > 0) {
                count += 1;
            }
        }

        return count;
    }
}