// https://leetcode.com/problems/letter-combinations-of-a-phone-number
// Complexity: O(4^n)
// Space: O(n) for acc, if res is considered then O(4^n)
class Solution {
    // Look up table that contains all possible letters a digit can denote
    char[][] d = {
        {}, // 0
        {}, // 1
        {'a', 'b', 'c'}, // 2
        {'d', 'e', 'f'}, // 3
        {'g', 'h', 'i'}, // 4
        {'j', 'k', 'l'}, // 5
        {'m', 'n', 'o'}, // 6
        {'p', 'q', 'r', 's'}, // 7
        {'t', 'u', 'v'}, // 8
        {'w', 'x', 'y', 'z'}, // 9
    };
    
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        
        // If the string is empty we would like to return empty list
        if (!digits.isEmpty()) {
            char[] acc = new char[digits.length()];
            build(digits, 0, acc, res);
        }
        return res;
    }
    
    void build(String digits, int i, char[] acc, List<String> res) {
        // If i is acc.length, we have a combination
        if (i == acc.length) {
            res.add(new String(acc));
            return;
        }
        
        // For each letter that can be denoted by the digit[i], we
        // add that to acc at ith position and recursively do it for i + 1
        for (char letter: d[digits.charAt(i) - 48]) {
            acc[i] = letter;
            build(digits, i + 1, acc, res);
        }
    }
}