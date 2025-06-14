// https://leetcode.com/problems/lexicographical-numbers
class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= Math.min(9, n); i++) {
            build(i, n, res);
        }

        return res;
    }

    boolean build(int curr, int max, List<Integer> res) {
        if (curr > max) {
            return false;
        }

        res.add(curr);

        for (int i = 0; i < 10; i++) {
            boolean b = build(curr * 10 + i, max, res);
            if (!b)
                break;
        }

        return true;
    }
}