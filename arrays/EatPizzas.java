// https://leetcode.com/problems/eat-pizzas/
class Solution {
    public long maxWeight(int[] pizzas) {
        long sum = 0;

        Arrays.sort(pizzas);
        int l = 0, r = pizzas.length - 1, d = 1;

        // Odd
        for (int i = 0; i < Math.ceil((pizzas.length / 4f) / 2); i++) {
            l += 3;
            sum += pizzas[r];
            r -= 1;
        }

        // Even
        while (r - l > 1) {
            l += 2;
            r -= 2;
            sum += pizzas[r + 1];
        }

        return sum;
    }
}