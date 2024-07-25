// https://leetcode.com/problems/generate-binary-strings-without-adjacent-zeros
class Solution {
    public List<String> validStrings(int n) {
        List<String> store = new ArrayList<>();
        gen(n, 0, 1, 0, store);
        return store;
    }

    String pad(String s, int n) {
        while (s.length() < n) {
            s = "0" + s;
        }

        return s;
    }

    void gen(
        int n,
        int i, int last, int curr,
        List<String> store
    ) {
        if (i == n) {
            store.add(pad(Integer.toBinaryString(curr), n));
            return;
        }

        if (last == 0) {
            gen(n, i + 1, 1, curr * 2 + 1, store);
        } else {
            gen(n, i + 1, 0, curr * 2, store);
            gen(n, i + 1, 1, curr * 2 + 1, store);
        }
    }
}