// https://leetcode.com/problems/water-bottles-ii/
class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int count = 0;
        while (numBottles >= numExchange) {
            // Drink numExchange
            count += numExchange;
            numBottles -= numExchange;

            // Exchange
            numBottles += 1;
            numExchange += 1;
        }

        return count + numBottles;
    }
}