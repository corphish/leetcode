// https://leetcode.com/problems/calculate-money-in-leetcode-bank
class Solution {
    public int totalMoney(int n) {
        int weeks = n/7;
        int firstWeekTotal = 28;
        int weeklyTotalWithoutInc = weeks * firstWeekTotal;
        int weeklyTotalWithInc = weeklyTotalWithoutInc + 7 * (weeks * (weeks - 1))/2;

        int lastWeekStart = weeks + 1;
        int lastWeekRem = n % 7;
        int lastWeekTotal = (lastWeekRem) * (2 * lastWeekStart + (lastWeekRem - 1))/2;

        return lastWeekTotal + weeklyTotalWithInc;
    }
}