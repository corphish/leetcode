// https://leetcode.com/problems/broken-calculator
class Solution {
    public int brokenCalc(int startValue, int target) {
        if (startValue == target) return 0;
        if (target < startValue) return startValue - target;
        if (target % 2 == 0) {
            return 1 + brokenCalc(startValue, target/2);
        } else {
            return 1 + brokenCalc(startValue, target + 1);
        }
    }
}