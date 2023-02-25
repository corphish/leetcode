// https://leetcode.com/problems/minimize-deviation-in-array
class Solution {
    public int minimumDeviation(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();

        for(int x: nums) {
            if (x % 2 == 1) set.add(2 * x);
            else set.add(x);
        }

        int min = set.last() - set.first();

        while (set.last() % 2 == 0) {
            int x = set.pollLast();
            set.add(x/2);
            min = Math.min(min, set.last() - set.first());
        }

        return min;
    }
}