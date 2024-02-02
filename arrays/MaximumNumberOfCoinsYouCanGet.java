// https://leetcode.com/problems/maximum-number-of-coins-you-can-get
class Solution {
    public int maxCoins(int[] piles) {
        // [2, 4, 1, 2, 7, 8]
        // [1, 2, 2, 4, 7 ,8]
        
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