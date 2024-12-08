// https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag/
class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int max = 0;
        for (int x: nums) max = Math.max(max, x);

        int low = 1, high = max;
        int res = max;

        while (low <= high) {
            int mid = (low + high)/2;
            boolean b = check(nums, maxOperations, mid);

            if (b) {
                res = Math.min(res, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        } 

        return res;
    }

    boolean check(int[] nums, int op, int test) {
        for (int x: nums) {
            if (x <= test) {
                continue;
            }

            int req = (x/test) - (x % test == 0 ? 1 : 0);
            if (req > op) {
                return false;
            }

            op -= req;
        }

        return true;
    }
}