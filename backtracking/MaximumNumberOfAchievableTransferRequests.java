// https://leetcode.com/problems/maximum-number-of-achievable-transfer-requests
class Solution {
    int max = 0;
    public int maximumRequests(int n, int[][] requests) {
        int[] state = new int[n];
        check(requests, 0, 0, state);
        return max;
    }

    void check(int[][] req, int i, int count, int[] state) {
        // Check state first
        boolean allZeroes = true;
        for (int x: state) {
            if (x > 0) {
                allZeroes = false;
                break;
            }
        }

        if (allZeroes) {
            max = Math.max(max, count);
        }

        if (i >= req.length) {
            return;
        }

        // Dont consider this request
        check(req, i + 1, count, state);

        // Consider this one
        state[req[i][0]] -= 1;
        state[req[i][1]] += 1;

        check(req, i + 1, count + 1, state);

        state[req[i][0]] += 1;
        state[req[i][1]] -= 1;
    }
}