// https://leetcode.com/problems/count-the-number-of-fair-pairs
class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        long count = 0;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int min = lower - nums[i];
            int max = upper - nums[i];
            int buff = 0;

            if (max < nums[i]) {
                continue;
            }

            int minIx = Arrays.binarySearch(nums, i + 1, nums.length, min);
            int maxIx = Arrays.binarySearch(nums, i + 1, nums.length, max);

            if (minIx < 0) {
                minIx = -minIx - 1;
            } else {
                minIx = getExtremePosition(nums, min, minIx, i, 0);
                buff = 1;
            }

            if (maxIx < 0) {
                maxIx = -maxIx - 1;
                while (nums[--maxIx] > max);
                buff = 1;
            } else {
                maxIx = getExtremePosition(nums, max, maxIx, i, 1);
                buff = 1;
            }

            count += maxIx - minIx + buff;
        }

        return count;
    }

    int getExtremePosition(int[] nums, int val, int currIx, int i, int dir) {
        int pos = -1, lastPos = currIx;
        if (currIx > 0 && currIx < nums.length - 1) {
            if (nums[currIx + (dir == 0 ? -1 : 1)] != val) {
                return currIx;
            }
        }
        while (true) {
            if (dir == 0) {
                pos = Arrays.binarySearch(nums, i + 1, lastPos + 1, val);
            } else {
                pos = Arrays.binarySearch(nums, lastPos + 1, nums.length, val);
            }

            if (pos < 0 || nums[pos] != val || lastPos == pos) {
                break;
            }

            lastPos = pos;
        }

        return lastPos;
    }
}