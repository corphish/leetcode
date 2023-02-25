// https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/
class Solution {
    public int countOdds(int low, int high) {
        boolean isOdd = low % 2 == 1 || high % 2 == 1;
        return (high - low)/2 + (isOdd ? 1 : 0);
    }
}