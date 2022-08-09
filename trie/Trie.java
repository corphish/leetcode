// https://leetcode.com/problems/implement-trie-prefix-tree/
class Trie {
    
    TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode crawl = root;
        int n = word.length();
        
        for (int i = 0; i < n; i++) {
            int level = word.charAt(i) - 97;
            if (crawl.children[level] == null) crawl.children[level] = new TrieNode();
            crawl = crawl.children[level];
        }
        
        crawl.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode crawl = root;
        int n = word.length();
        
        for (int i = 0; i < n; i++) {
            int level = word.charAt(i) - 97;
            TrieNode child = crawl.children[level];
            
            if (child == null) return false;
            crawl = child;
        }
        
        return crawl.isEnd;
    }
    
    public boolean startsWith(String word) {
        TrieNode crawl = root;
        int n = word.length();
        
        for (int i = 0; i < n; i++) {
            int level = word.charAt(i) - 97;
            TrieNode child = crawl.children[level];
            
            if (child == null) return false;
            crawl = child;
        }
        
        return true;
    }
    
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */