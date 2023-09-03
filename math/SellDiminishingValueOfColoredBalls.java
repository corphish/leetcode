// https://leetcode.com/problems/sell-diminishing-valued-colored-balls
import java.math.BigInteger;

class Solution {
    public int maxProfit(int[] inventory, int orders) {
        Arrays.sort(inventory);
        int x = inventory.length - 1;
        int MOD = 1000000007;
        BigInteger B = BigInteger.ZERO;

        while (orders > 0) {
            int currLargest = inventory[x];
            int nextLargest = x > 0 ? inventory[x - 1] : -1;
            int itemCount = inventory.length - x;
            int iter = orders/itemCount;
            int iterRem = orders % itemCount;

            if (nextLargest == -1) {
                B = B.add(BigInteger.valueOf(APSum(currLargest, iter)).multiply(BigInteger.valueOf(itemCount)));
                B = B.add(BigInteger.valueOf(currLargest - iter).multiply(BigInteger.valueOf(iterRem)));
                break;
            } else {
                int diff = currLargest - nextLargest;
                if (diff * itemCount > orders) {
                    B = B.add(BigInteger.valueOf(APSum(currLargest, iter)).multiply(BigInteger.valueOf(itemCount)));
                    B = B.add(BigInteger.valueOf(currLargest - iter).multiply(BigInteger.valueOf(iterRem)));
                    break;
                } else {
                    B = B.add(BigInteger.valueOf(APSum(currLargest, diff)).multiply(BigInteger.valueOf(itemCount)));
                    orders -= diff * itemCount;
                }
            }

            x -= 1;
        }

        return B.mod(BigInteger.valueOf(MOD)).intValue();
    }

    long APSum(int a, int n) {
        long x = a, count = n;
        return (count * (2 * x + 1 - count))/2 % 1000000007;
    }
}