class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        PalindromeManager manager = new PalindromeManager(words);
        TrieNode head = new TrieNode(), t = head;
        int emptyIndex = -1;
        
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (words[i].isEmpty()) {
                emptyIndex = i;
                continue;
            }
            
            for (int j = word.length() - 1; j >= 0; j--) {
                char c = word.charAt(j);
                if (t.children[c - 'a'] == null) {
                    t.children[c - 'a'] = new TrieNode();
                }
                
                t = t.children[c - 'a'];
                t.words.add(word);
            }
            
            t.index = i;
            t = head;
        }
        
        if (emptyIndex != -1) {
            for (int index: manager.getPalindromeIndices()) {
                if (emptyIndex != index) {
                    res.add(List.of(emptyIndex, index));
                    res.add(List.of(index, emptyIndex));
                }
            }
        }
        
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.isEmpty()) {
                continue;
            }
            
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                t = t.children[c - 'a'];
                if (t != null) {
                    // If current trie position indicates a word terminal
                    if (t.index != -1 && t.index != i) {
                        // Right now we added upto i chars from word we are checking
                        // And here we have encountered another terminal word
                        // So concatenating chars encountered so far and the word will be a palindrome
                        // It will also be a palindrome if the remaining chars form a palindrome.
                        PalindromicPart part = manager.get(word);
                        if (part.isSuffixPalindrome(j + 1)) {
                            res.add(List.of(i, t.index));
                        }
                    }
                } else {
                    break;
                }
            }
            
            if (t != null) {
                for (String check: t.words) {
                    PalindromicPart part = manager.get(check);
                    int checkIndex = manager.indexOf(check);
                    if (i != checkIndex && part.isPrefixPalindrome(check.length() - word.length() - 1)) {
                        res.add(List.of(i, checkIndex));
                    }
                }
            }
            
            t = head;
        }
        
        return res;
    }
    
    class PalindromicPart {
        // Set of indices such that s[0..index] is palindrome
        Set<Integer> prefixPalindromeIndices = new HashSet<>();
        
        // Set of indices such that s[index..s.length() - 1] is palindrome
        Set<Integer> suffixPalindromeIndices = new HashSet<>();
        
        boolean isPrefixPalindrome(int index) {
            return prefixPalindromeIndices.contains(index);
        }
        
        boolean isSuffixPalindrome(int index) {
            return suffixPalindromeIndices.contains(index);
        }
        
        private void processPrefixes(String s) {
            StringBuilder sb = new StringBuilder();
            StringBuilder rev = new StringBuilder();
            char last = 0;
            boolean prefixBroken = false;
            
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                sb.append(c);
                rev.insert(0, c);
                
                if (last == 0) {
                    prefixPalindromeIndices.add(i);
                    last = c;
                    continue;
                } else if (!prefixBroken && last == c) {
                    prefixPalindromeIndices.add(i);
                    continue;
                } else {
                    prefixBroken = true;
                }
                
                if (c == rev.charAt(rev.length() - 1) && sb.toString().equals(new StringBuilder(sb).reverse().toString())) {
                    prefixPalindromeIndices.add(i);
                }
                
                last = c;
            }
            
            // Empty prefix is still a palindrome
            prefixPalindromeIndices.add(s.length());
        }
        
        private void processSuffixes(String s) {
            StringBuilder sb = new StringBuilder(s);
            StringBuilder rev = new StringBuilder(s).reverse();
            
            for (int i = 0; i < s.length(); i++) {                
                if (sb.toString().equals(rev.toString())) {
                    suffixPalindromeIndices.add(i);
                }                
                
                sb.deleteCharAt(0);
                rev.deleteCharAt(rev.length() - 1);
            }
            
            // Empty suffix is still a palindrome
            suffixPalindromeIndices.add(s.length());
        }
        
        PalindromicPart(String s) {
            processPrefixes(s);
            processSuffixes(s);
        }
    }
    
    class PalindromeManager {
        Map<String, PalindromicPart> map = new HashMap<>();
        Set<Integer> palindromeIndices = new HashSet<>();
        Map<String, Integer> indexMap = new HashMap<>();
        
        PalindromeManager(String[] words) {
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                PalindromicPart p = new PalindromicPart(word);
                map.put(word, p);
                indexMap.put(word, i);
                if (p.isSuffixPalindrome(0)) {
                    palindromeIndices.add(i);
                }
            }
        }
        
        int indexOf(String word) {
            return indexMap.getOrDefault(word, -1);
        }
        
        PalindromicPart get(String word) {
            return map.get(word);
        }
        
        Set<Integer> getPalindromeIndices() {
            return palindromeIndices;
        }
    }
    
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        
        // Index of the word that ends here
        int index = -1;
        
        // List of words formed by this trie
        List<String> words = new ArrayList<>();
    }
}