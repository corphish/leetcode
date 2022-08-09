https://leetcode.com/problems/find-and-replace-pattern/
class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        
        for (String word: words) {
            if (remapMatches(word, pattern)) {
                res.add(word);
            }
        }
        
        return res;
    }
    
    boolean remapMatches(String word, String pattern) {
        Map<Character, Character> map = new HashMap<>();
        Map<Character, Character> revMap = new HashMap<>();
        int n = word.length();
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            char a = word.charAt(i);
            char b = pattern.charAt(i);
            
            if (!map.containsKey(b) && !revMap.containsKey(a)) {
                map.put(b, a);    
                revMap.put(a, b);
            }
            
            Character c = map.get(b);
            if (c == null) {
                return false;
            }
            
            sb.append(c);
        }
        
        return word.equals(sb.toString());
    }
}