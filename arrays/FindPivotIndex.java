// https://leetcode.com/problems/find-pivot-index/
class Solution {
    public int pivotIndex(int[] nums) {
        int[] prefix = nums.clone();
        for (int i = 1; i < nums.length; i++) {
            prefix[i] += prefix[i - 1];
        }

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                if (prefix[nums.length - 1] - prefix[0] == 0) {
                    return 0;
                }
            } else if (i == nums.length - 1) {
                if (prefix[nums.length - 2] == 0) {
                    return nums.length - 1;
                }
            } else {
                if (prefix[i - 1] == prefix[nums.length - 1] - prefix[i]) {
                    return i;
                }
            }
        }

        return -1;
    }
}