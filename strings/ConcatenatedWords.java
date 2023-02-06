// https://leetcode.com/problems/concatenated-words
class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        Set<String> set = new HashSet<>();
        List<String> res = new ArrayList<>();
        
        for (String s: words) set.add(s);
        int minLength = words[0].length();
        
        for (int i = words.length - 1; i >= 0 && words[i].length() > minLength; i--) {
            if (isPresent(set, words[i], minLength, true)) {
                res.add(words[i]);
            }
        }
        
        return res;
    }
    
    public boolean isPresent(Set<String> s, String word, int minLength, boolean fullWord) {
        if (word.isEmpty()) {
            return true;
        }
        
        for (int i = minLength; i <= word.length(); i++) {
            String sub = word.substring(0, i);
            if ((fullWord && !sub.equals(word) || !fullWord) && s.contains(sub)) {
                boolean res = isPresent(s, word.substring(i), minLength, false);
                if (res) return true;
            }
        }
        
        return false;
    }
}