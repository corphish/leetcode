// https://leetcode.com/problems/points-that-intersect-with-cars/
class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        int[] arr = new int[102];

        for (var p: nums) {
            arr[p.get(0)] += 1;
            arr[p.get(1) + 1] -= 1;
        }

        int count = 0;
        for (int i = 1; i < arr.length; i++) {
            arr[i] += arr[i - 1];
            if (arr[i] > 0) {
                count += 1;
            }
        }

        return count;
    }
}