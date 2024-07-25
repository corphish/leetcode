// https://leetcode.com/problems/minimum-number-of-chairs-in-a-waiting-room/
class Solution {
    public int minimumChairs(String s) {
        int count = 0, res = 0;
        for (char c: s.toCharArray()) {
            if (c == 'E') {
                count += 1;
            } else {
                count -= 1;
            }

            res = Math.max(res, count);
        }

        return res;
    }
}