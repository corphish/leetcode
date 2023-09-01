// https://leetcode.com/problems/frog-jump
class Solution {
    public boolean canCross(int[] arr) {
        if (arr[1] != 1) {
            return false;
        }

        int n = arr.length, k = 1;
        boolean[][] dp = new boolean[n][n];
        dp[0][0] = dp[1][1] = true;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (dp[i][j]) {
                    // We are here because we were able to jump from somehere to here (i) with a jump
                    // length = j
                    int ix;
                    if ((ix = map.getOrDefault(arr[i] + j, -1)) > i) {
                        dp[ix][j] = true;
                    }

                    if ((ix = map.getOrDefault(arr[i] + j - 1, -1)) > i) {
                        dp[ix][j - 1] = true;
                    }

                    if ((ix = map.getOrDefault(arr[i] + j + 1, -1)) > i) {
                        dp[ix][j + 1] = true;
                    }
                }
            }
        }

        for (boolean b: dp[n - 1]) {
            if (b) return true;
        }

        return false;

        // For recursive uncomment this
        /*int[][] memo = new int[n][n];
        return check(arr, 1, 1, memo);*/
    }

    boolean check(int[] arr, int pos, int k, int[][] memo) {
        if (pos >= arr.length) {
            return false;
        }

        if (pos == arr.length - 1) {
            return true;
        }

        if (memo[pos][k] != 0) {
            System.out.println("memo =" + memo[pos][k]);
            return memo[pos][k] == 1;
        }

        boolean res = false;
        for (int i = pos + 1; i < arr.length; i++) {
            if (arr[i] == arr[pos] + k - 1) {
                res |= check(arr, i, k - 1, memo);
            } else if (arr[i] == arr[pos] + k) {
                res |= check(arr, i, k, memo);
            } else if (arr[i] == arr[pos] + k + 1) {
                res |= check(arr, i, k + 1, memo);
            } else if (arr[i] > arr[pos] + k + 1) {
                break;
            }
        }

        memo[pos][k] = res ? 1 : 2;

        return res;
    }
}