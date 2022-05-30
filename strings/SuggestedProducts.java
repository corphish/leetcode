// https://leetcode.com/problems/search-suggestions-system
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        TrieNode head = new TrieNode(), t = head;
        for (String p: products) {
            for (char c: p.toCharArray()) {
                if (t.children[c - 'a'] == null) {
                    t.children[c - 'a'] = new TrieNode();
                }
                
                t.children[c - 'a'].words.add(p);
                t = t.children[c - 'a'];
            }
            
            t = head;
        }
        
        for (char c: searchWord.toCharArray()) {
            Set<String> words;
            if (t != null) {
                t = t.children[c - 'a'];
            }
            
            if (t != null) {
                words = t.words;
            } else {
                words = Set.of();
            }
            
            res.add(words.stream().limit(3).collect(Collectors.toList()));
        }
        
        return res;
    }
    
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        Set<String> words = new TreeSet<>();
    }
}