// https://leetcode.com/problems/sort-colors
class Solution {
    public void sortColors(int[] nums) {
        int red = 0, blue = 0, white = 0;
        for (int x : nums) {
            if (x == 0)
                red++;
            if (x == 1)
                blue++;
            if (x == 2)
                white++;
        }

        int k = 0;
        for (int i = 0; i < red; i++) {
            nums[k++] = 0;
        }

        for (int i = 0; i < blue; i++) {
            nums[k++] = 1;
        }

        for (int i = 0; i < white; i++) {
            nums[k++] = 2;
        }
    }
}