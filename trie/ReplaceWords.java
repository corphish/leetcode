// https://leetcode.com/problems/replace-words
class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode head = new TrieNode(), t = head;
        
        // Build a trie from dictionay
        for (String word: dictionary) {
            for (char c: word.toCharArray()) {
                if (t.children[c - 'a'] == null) {
                    t.children[c - 'a'] = new TrieNode();
                }
                
                t = t.children[c - 'a'];
            }
            
            t.word = word;
            t = head;
        }
        
        List<String> res = new ArrayList<>();
        
        // Now for each word in sentence, see if there is a matching prefix in dictionary
        for (String word: sentence.split(" ")) {
            boolean hasMatch = false;
            for (char c: word.toCharArray()) {
                if (t.word != null) {
                    // We have a match
                    hasMatch = true;
                    res.add(t.word);
                    break;
                }
                
                if (t.children[c - 'a'] == null) {
                    // We dont have a match
                    break;
                }
                
                t = t.children[c - 'a'];
            }
            
            if (!hasMatch) {
                res.add(word);
            }
            
            t = head;
        }
        
        return String.join(" ", res);
    }
    
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        
        // Word denoted by this terminal
        String word;
    }
}