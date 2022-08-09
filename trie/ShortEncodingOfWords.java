// https://leetcode.com/problems/short-encoding-of-words
class Solution {
    // Build a suffix trie, and then traverse the trie to find the longest word that we can make starting from a node.
    // When we find that the node we have reached is terminal, we add that word to result.
    // Any other word which is a suffix of a word will already be included in the path.
    // In order to determine the word we are going to add, we store the word that the trie denotes at each terminal node.
    public int minimumLengthEncoding(String[] words) {
        TrieNode head = new TrieNode(), t = head;
        for (String word: words) {
            for (int i = word.length() - 1; i >= 0; i--) {
                char c = word.charAt(i);
                if (t.children[c - 'a'] == null) {
                    t.children[c - 'a'] = new TrieNode();
                }
                
                t = t.children[c - 'a'];
            }
            
            t.word = word;
            t = head;
        }
        
        // We need to traverse the trie, and form the longest possible word
        // and that to solution
        StringBuilder sb = new StringBuilder();
        traverse(head, sb);
        
        return sb.length();
    }
    
    void traverse(TrieNode node, StringBuilder acc) {
        boolean hasChildren = false;
        for (TrieNode child: node.children) {
            if (child != null) {
                traverse(child, acc);
                hasChildren = true;
            }
        }
        
        if (!hasChildren && node.word != null) {
            acc.append(node.word).append("#");
            // System.out.println("Considered " + node.word + ", builder = " + acc);
        }
    }
    
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        
        // Set of words that end here
        String word;
    }
}