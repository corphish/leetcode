class WordDictionary {
    
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
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
        return search(word, 0, root);
    }
    
    private boolean search(String word, int pos, TrieNode T) {
        int n = word.length();
        
        TrieNode crawl = T;
        
        if (pos >= n) return crawl.isEnd;
        if (crawl == null) return false;
        
        for (int i = pos; i < n; i++) {
            char letter = word.charAt(i);
            if (letter == '.') {
                boolean present = false;
                for (TrieNode t: crawl.children) {
                    if (t != null) {
                        present = present | search(word, i + 1, t);
                    }
                }
                
                return present;
            } else {
             
                int level = letter - 97;
                if (crawl.children[level] == null) return false;
                crawl = crawl.children[level];
            }
        }
        
        return crawl.isEnd;
    }
    
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */