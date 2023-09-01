// https://leetcode.com/problems/find-unique-binary-string
class Solution {
    String[] zeroes = {
        "",
        "0",
        "00",
        "000",
        "0000",
        "00000",
        "000000",
        "0000000",
        "00000000",
        "000000000",
        "0000000000",
        "00000000000",
        "000000000000",
        "0000000000000",
        "00000000000000",
        "000000000000000",
        "0000000000000000",
    };

    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        boolean[] tabill = new boolean[1 << n];
        int last = -1, start = 0;
        Arrays.sort(nums);

        for (String num: nums) {
            int x = Integer.parseInt(num, 2);
            if (x - last > 1) {
                start = x - 1;
                break;
            }
            tabill[x] = true;
            last = x;
        }

        for (int i = start; i < (1 << n); i++) {
            if (!tabill[i]) {
                String res = Integer.toBinaryString(i);
                return zeroes[n - res.length()] + res;
            }
        }

        return "";
    }
}