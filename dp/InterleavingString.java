// https://leetcode.com/problems/interleaving-string
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int[][][] dp = new int[s3.length()][s1.length() + 1][s2.length() + 1];
        return check(s1, s2, s3, 0, 0, 0, dp);
    }

    boolean check(
        String s1,
        String s2,
        String s3,
        int p1,
        int p2,
        int p3,
        int[][][] memo
    ) {
        if (p3 >= s3.length() && p1 >= s1.length() && p2 >= s2.length()) {
            return true;
        }

        if (p3 >= s3.length()) {
            return false;
        }

        if (memo[p3][p1][p2] != 0) {
            return memo[p3][p1][p2] == 1;
        }

        boolean res = false;

        if (p1 < s1.length() && p2 < s2.length()) {
            if (s1.charAt(p1) == s3.charAt(p3) && s2.charAt(p2) == s3.charAt(p3)) {
                res = check(s1, s2, s3, p1 + 1, p2, p3 + 1, memo) || check(s1, s2, s3, p1, p2 + 1, p3 + 1, memo);
            } else if (s1.charAt(p1) == s3.charAt(p3)) {
                res = check(s1, s2, s3, p1 + 1, p2, p3 + 1, memo);
            } else if (s2.charAt(p2) == s3.charAt(p3)) {
                res = check(s1, s2, s3, p1, p2 + 1, p3 + 1, memo);
            }
        } else if (p1 < s1.length()) {
            if (s1.charAt(p1) == s3.charAt(p3)) {
                res = check(s1, s2, s3, p1 + 1, p2, p3 + 1, memo);
            }
        } else if (p2 < s2.length()) {
            if (s2.charAt(p2) == s3.charAt(p3)) {
                res = check(s1, s2, s3, p1, p2 + 1, p3 + 1, memo);
            }
        }

        memo[p3][p1][p2] = res ? 1 : 2;

        return res;
    }
}