// https://leetcode.com/problems/largest-number
class Solution {
    public String largestNumber(int[] nums) {
        Integer[] r = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            r[i] = Integer.valueOf(nums[i]);
        }

        Arrays.sort(r, (a, b) -> compare(a, b));

        StringBuilder res = new StringBuilder();
        boolean flag = false;

        for (var x: r) {
            if (x == 0 && !flag) {
                continue;
            }

            if ((x == 0 && flag) || x != 0) {
                flag = true;
                res.append(x);
            }
        }

        return res.length() == 0 ? "0" : res.toString();
    }

    int compare(int a, int b) {
        if (a == 0) {
            return 1;
        }

        if (b == 0) {
            return -1;
        }

        double x = a;
        double y = b;

        for (int p = b; p > 0; p /= 10, x *= 10);
        for (int p = a; p > 0; p /= 10, y *= 10);

        return Double.compare(y + a, x + b);
    }
}