// https://leetcode.com/problems/water-bottles
class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int count = 0, k = 0;
        while (numBottles >= numExchange) {
            k = (numBottles/numExchange) * numExchange;
            count += k;
            numBottles -= k;
            numBottles += k/numExchange;
        }

        return count + numBottles;
    }
}