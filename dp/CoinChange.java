class Solution {
    /**
     * Logic: Generate the possible combinations, if amount comes to be zero, combination is possible
     * Hence, return 0. If amount comes to be negative, combination is not possible, return some fixed value (-1) which needs to later checked.
     * Taking each coin, generate all the combination, and keep track of the minimum when a combination is possible.
     * Memoize the min value against and the amount and re-use it wherever possible.
     */
    public int coinChange(int[] coins, int amount) {
        return minCoinChange(coins, amount, new HashMap<>());
    }
    
    public int minCoinChange(int[] coins, int amount, Map<Integer, Integer> memo) {
        if (memo.containsKey(amount)) return memo.get(amount);
        
        if (amount == 0) {
            return 0;
        }
        
        if (amount < 0) {
            return -1;
        }
        
        int min = -1;
        
        for (int coin: coins) {
            int remainderSize = minCoinChange(coins, amount - coin, memo);
            if (remainderSize != -1) {
                if (min == -1 || remainderSize + 1 < min) 
                    min = remainderSize + 1;
            }
        }
        
        memo.put(amount, min);
        
        return min;
    }
}