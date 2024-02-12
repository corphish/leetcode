// https://leetcode.com/problems/ant-on-the-boundary/
class Solution {
    public int returnToBoundaryCount(int[] nums) {
        int pos = 0, count = 0;
        for (int x: nums) {
            pos += x;
            if (pos == 0) count += 1;
        }

        return count;
    }
}