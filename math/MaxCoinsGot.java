// https://leetcode.com/problems/maximum-number-of-coins-you-can-get/
class Solution {
    public int maxCoins(int[] piles) {
        // [2, 4, 1, 2, 7, 8]
        // [1, 2, 2, 4, 7 ,8]
        
        // Sort the array
        // Give alice the highest one
        // Give myself the second largest one
        // Give bob the smallest one
        // In other words, if n is the size of array, I can take
        // piles[n - 2], piles[n -  4] ... (because alice takes piles[n - 1], piles[n - 3])
        // However, we cannot take any thing from piles[0]..piles[n/3 - 1] because those are Bob's
        
        int n = piles.length;
        Arrays.sort(piles);
        
        if (n == 3) {
            return piles[1];
        }
        
        int count = 0;
        for (int i = n - 2; i >= n/3; i -= 2) {
            count += piles[i];
        }
        
        return count;
    }
}