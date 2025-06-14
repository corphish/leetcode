// https://leetcode.com/problems/minimum-number-of-days-to-eat-n-oranges
class Solution {
    public int minDays(int n) {
        return min(n, new HashMap<>());
    }

    final int INF = Integer.MAX_VALUE/3;
    int min(int n, Map<Integer, Integer> memo) {
        if (n <= 1) {
            return n;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int min = Math.min((n & 1) + min(n/2, memo), n % 3 + min(n/3, memo));
        memo.put(n, 1 + min);
        return 1 + min;
    }
}