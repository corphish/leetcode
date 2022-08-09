// https://leetcode.com/problems/map-sum-pairs/
class MapSum {
    
    // Prefix trie
    TrieNode head, t;
    Map<String, Integer> values;

    public MapSum() {
        head = new TrieNode();
        t = head;
        values = new HashMap<>();
    }
    
    private void insertIntoTrie(String word) {
        //System.out.println("Inserting " + word);
        for (char c: word.toCharArray()) {
            if (t.children[c - 'a'] == null) {
                t.children[c - 'a'] = new TrieNode();
            }
            
            t = t.children[c - 'a'];
            t.words.add(word);
        }
        
        //System.out.println("Added: new set = " + t.words);
        t = head;
    }
    
    public void insert(String key, int val) {
        values.put(key, val);
        insertIntoTrie(key);
    }
    
    public int sum(String prefix) {
        //System.out.println("Sum = " + prefix);
        for (char c: prefix.toCharArray()) {
            if (t.children[c - 'a'] == null) {
                // It is important that we reset our to head here
                t = head;
                return 0;
            }
            
            t = t.children[c - 'a'];
        }
        
        int sum = 0;
        for (String word: t.words) {
            sum += values.get(word);
        }
        
        // Even after search is successful, we reset t
        t = head;
        
        return sum;
    }
    
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        Set<String> words = new HashSet<>();
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */