class Solution {
    public int change(int amount, int[] coins) {
        return calculate(amount, coins, 0, new HashMap<>());
    }
    
    // In order to avoid duplicate combination, we need to pass a start variable
    // which indicates which coin to start with.
    // In addition to that, we have to consider this start value to generate the key
    // for memoization.
    public int calculate(int amount, int[] coins, int start, Map<String, Integer> memo) {
        if (amount < 0) {
            return 0;
        }
        
        String key = start + "," + amount;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        
        if (amount == 0) {
            return 1;
        }
        
        int total = 0;
        
        for (int i = start; i < coins.length; i++) {
            int remainingWays = calculate(amount - coins[i], coins, i, memo);
            total += remainingWays;
        }
        
        memo.put(key, total);
        return total;
    }
}