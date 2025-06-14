// https://leetcode.com/problems/prime-pairs-with-target-sum/
class Solution {
    public List<List<Integer>> findPrimePairs(int n) {
        boolean[] sieve = new boolean[n + 1];
        sieve(sieve);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 2; i <= n / 2; i++) {
            if (sieve[i] && sieve[n - i]) {
                res.add(Arrays.asList(i, n - i));
            }
        }

        return res;
    }

    void sieve(boolean[] arr) {
        Arrays.fill(arr, true);

        arr[1] = false;
        for (int i = 2; i < arr.length; i++) {
            if (!arr[i]) {
                continue;
            }

            for (int j = 2 * i; j < arr.length; j += i) {
                arr[j] = false;
            }
        }
    }
}