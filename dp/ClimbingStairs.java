// n = 4
// 1 + 1 + 1 + 1
// 1 + 1 + 2
// 1 + 2 + 1
// 2 + 1 + 1
// 2 + 2
// https://leetcode.com/problems/climbing-stairs
class Solution {
    public int climbStairs(int n) {
        int[] arr = new int[n + 1];
        
        arr[0] = 0;
        arr[1] = 1;
        if (n > 1)
            arr[2] = 2;
        
        // (n - 1)th step is overlapped. (n - 2)th step is also overlapped except for the last step.
        for (int i = 3; i <= n; i++) {
            arr[i] = 1 + arr[i - 1] + (arr[i - 2] - 1);
        }
        
        return arr[n];
    }
}