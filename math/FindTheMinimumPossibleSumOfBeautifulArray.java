// https://leetcode.com/problems/find-the-minimum-possible-sum-of-a-beautiful-array
class Solution {
    public int minimumPossibleSum(int n, int target) {
        long sum = 0;
        long first = Math.min(n, target/2);
        sum += (first * (first + 1))/2;
        n -= first;
        if (n > 0)
            sum += (n * (2L * target + n - 1))/2;

        return (int) (sum % 1000000007);
    }
}