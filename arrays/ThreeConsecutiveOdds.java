// https://leetcode.com/problems/three-consecutive-odds
class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        if (arr.length < 3) {
            return false;
        }

        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i - 1] % 2 == 1 && arr[i] % 2 == 1 && arr[i + 1] % 2 == 1) {
                return true;
            }
        }

        return false;
    }
}