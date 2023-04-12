// https://leetcode.com/problems/reducing-dishes/
class Solution {
    public int maxSatisfaction(int[] arr) {
        int max = 0, curr = 0, sum = 0;
        Arrays.sort(arr);

        for (int i = arr.length - 1; i >= 0; i--) {
            sum += arr[i];
            curr += sum;
            max = Math.max(max, curr);
        }

        return max;
    }
}