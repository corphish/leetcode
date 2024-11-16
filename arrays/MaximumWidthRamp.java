// https://leetcode.com/problems/maximum-width-ramp
class Solution {
    public int maxWidthRamp(int[] nums) {
        int max = 0, res = 0, t = 0;
        int last = Integer.MAX_VALUE/2;
        boolean isDescending = true;
        boolean isD2 = true;
        for (int x: nums) {
            if (x == last) {
                isDescending = false;
                if (x == last) {
                    res = Math.max(res, ++t);
                } else {
                    t = 1;
                }
            } else if (x > last) {
                isD2 = false;
                isDescending = false;
                t = 1;
            } else {
                t = 0;
            }
            max = Math.max(max, x);
            last = x;
        }

        if (isDescending) {
            return 0;
        }

        if (!isDescending && isD2) {
            return res;
        }

        int[] pos = new int[max + 1];
        Arrays.fill(pos, -1);

        for (int i = 0; i < nums.length; i++) {
            pos[nums[i]] = i;
        }

        last = Integer.MIN_VALUE/2;
        for (int i = max; i >= 0; i--) {
            if (pos[i] >= 0) {
                last = i;
            } else {
                pos[i] = -last;
            }
        }

        last = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (x >= last) continue;
            for (int j = x; j <= max; j++) {
                if (pos[j] >= 0) {
                    res = Math.max(res, pos[j] - i);
                    last = x;
                } else {
                    j = -pos[j];
                    j -= 1;
                }
            }
        }

        return res;
    }
}