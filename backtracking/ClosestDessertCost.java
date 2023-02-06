// https://leetcode.com/problems/closest-dessert-cost
class Solution {
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        int max = 0, min = Integer.MAX_VALUE;
        TreeSet<Integer> set = new TreeSet<>();
        for (int x: baseCosts) {
            max = Math.max(max, max(toppingCosts, x, 0, target, set));
        }

        if (set.isEmpty()) return max;

        int greater = set.first();
        return max == 0 ? greater : target - max <= greater - target ? max : greater;
    }

    int max(int[] arr, int curr, int x, int target, Set<Integer> greater) {
        if (curr == target) {
            return target;
        }

        if (curr > target) {
            greater.add(curr);
            return -1;
        }

        int max = curr;
        for (int i = x; i < arr.length; i++) {
            max = Math.max(max, max(arr, curr + arr[i], i + 1, target, greater));
            max = Math.max(max, max(arr, curr + (2 * arr[i]), i + 1, target, greater));
        }

        return max;
    }
}