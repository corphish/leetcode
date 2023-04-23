// https://leetcode.com/problems/combination-sum-iii
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] temp = new int[k];
        List<List<Integer>> res = new ArrayList<>();
        gen(n, k, 1, temp, res);
        return res;
    }

    void gen(int n, int k, int i, int[] temp, List<List<Integer>> res) {
        if (n < 0) {
            return;
        }

        if (i > 9) {
            return;
        }

        if (k < 1) {
            return;
        }

        if (k == 1) {
            if (n < 10 && n >= i) {
                temp[temp.length - k] = n;
                List<Integer> ans = new ArrayList<>();
                for (int x: temp) ans.add(x);
                res.add(ans);
            }
            
            return;
        }

        // Choose i
        temp[temp.length - k] = i;
        gen(n - i, k - 1, i + 1, temp, res);

        // Dont choose i
        gen(n, k, i + 1, temp, res);
    }
}