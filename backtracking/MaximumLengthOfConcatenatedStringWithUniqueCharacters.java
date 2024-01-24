// https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters
class Solution {
    public int maxLength(List<String> arr) {
        boolean[] state = new boolean[26];
        return max(arr, 0, state);
    }

    int max(List<String> arr, int i, boolean[] state) {
        if (i >= arr.size()) {
            return 0;
        }

        int max = max(arr, i + 1, state);
        for (char c: arr.get(i).toCharArray()) {
            if (state[c - 'a']) {
                return max;
            }
        }

        boolean hasRep = false;
        for (char c: arr.get(i).toCharArray()) {
            if (!state[c - 'a'])
                state[c - 'a'] = true;
            else 
                hasRep = true;
        }

        if (!hasRep)
            max = Math.max(max, arr.get(i).length() + max(arr, i + 1, state));

        for (char c: arr.get(i).toCharArray()) {
            state[c - 'a'] = false;
        }

        return max;
    }
}