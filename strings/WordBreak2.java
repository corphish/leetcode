// https://leetcode.com/problems/word-break-ii
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>(wordDict);
        breakWord(s, set, new Stack<>(), res);
        return res;
    }
    
    // We take each character from start of the passed string.
    // If the word formed by accumulation of the letters is present in dict,
    // we add that word as a potential result and recurse for the remaining string.
    // else we keep on adding letters.
    public void breakWord(
        String s, 
        Set<String> wordDict, 
        Stack<String> acc, 
        List<String> res
    ) {
        if (s.isEmpty()) {
            res.add(String.join(" ", acc));
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (wordDict.contains(sb.toString())) {
                acc.push(sb.toString());
                breakWord(s.substring(i + 1), wordDict, acc, res);
                acc.pop();
            }
        }
    }
}