// https://leetcode.com/problems/arithmetic-subarrays/
class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            int[] sub = new int[r[i] - l[i] + 1];
            for (int j = l[i], k = 0; j <= r[i]; k++, j++) {
                sub[k] = nums[j];
            }

            Arrays.sort(sub);
            boolean rx = true;
            for (int j = 1; j < sub.length; j++) {
                if (sub[j] - sub[j - 1] != sub[1] - sub[0]) {
                    rx = false;
                    break;
                }
            }

            res.add(rx);
        }

        return res;
    }
}