// https://leetcode.com/problems/letter-case-permutation
class Solution {
    public List<String> letterCasePermutation(String s) {
        Set<String> store = new HashSet<>();
        store.add(s);
        gen(s.toCharArray(), 0, store);
        return new ArrayList<>(store);
    }

    void gen(char[] letters, int start, Set<String> store) {
        if (start >= letters.length) return;
        if (letters[start] < 'A') {
            gen(letters, start + 1, store);
            return;
        }

        // Make uppercase
        letters[start] = Character.toUpperCase(letters[start]);
        store.add(new String(letters));
        gen(letters, start + 1, store);

        // Make lowercase
        letters[start] = Character.toLowerCase(letters[start]);
        store.add(new String(letters));
        gen(letters, start + 1, store);
    }
}