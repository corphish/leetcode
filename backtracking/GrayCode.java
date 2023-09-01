// https://leetcode.com/problems/gray-code/
class Solution {
    public List<Integer> grayCode(int n) {
        int[] bitset = new int[n];
        boolean[] present = new boolean[1 << n];
        List<Integer> res = new ArrayList<>();

        gen(bitset, res, present);
        return res;
    }

    void gen(int[] bitset, List<Integer> res, boolean[] present) {
        int x = convert(bitset);
        if (!present[x]) {
            res.add(x);
            present[x] = true;
        } else {
            return;
        }

        for (int i = 0; i < bitset.length; i++) {
            int old = bitset[i];
            bitset[i] = old == 0 ? 1 : 0;
            gen(bitset, res, present);
            bitset[i] = old;
        }
    }

    int convert(int[] bitset) {
        int res = 0;
        for (int x: bitset) {
            res = res * 2 + x;
        }

        return res;
    }
}