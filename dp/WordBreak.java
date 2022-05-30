class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        // Memo: 0 - Not initialized, 1 - true, 2 - false
        int[] memo = new int[s.length()];
        return breakWord(s, 0, set, memo);
    }
    
    // First come up with normal brute force approach
    // Brute force: Try building the string from start, and once we have a match
    // try breaking the formed word and re-call the recursive method on the remaining word.
    // Be sure to continue adding letters to the original formed word to support backtracking.
    // Now memoize, by storing the result of word formation against the start index.
    public boolean breakWord(String s, int start, Set<String> wordDict, int[] memo) {
        if (start == s.length()) return true;
        if (memo[start] != 0) return memo[start] == 1;
        
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (wordDict.contains(sb.toString())) {
                boolean res = breakWord(s, i + 1, wordDict, memo);
                if (res) {
                    memo[start] = 1;
                    return res;
                }
            }
        }
        
        memo[start] = 2;
        return false;
    }
}