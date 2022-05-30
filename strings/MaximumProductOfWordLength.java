// https://leetcode.com/problems/maximum-product-of-word-lengths
class Solution {
    // It is important that we check if 2 words share common letters in constant time.
    // Otherwise, the complexity grows to O(n*n*m) which causes TLE.
    // So, for each word, we pre-compute its letter frequency, and then for each pair
    // we match this freq and determine the max product, bringing the complexity to
    // O(n*m) + O(n*n).
    public int maxProduct(String[] words) {
        Word[] wordList = new Word[words.length];
        
        for (int i = 0; i < words.length; i++) {
            wordList[i] = new Word(words[i]);
        }
        
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j) {
                    Word a = wordList[i];
                    Word b = wordList[j];
                    
                    if (!a.sharesCommonLettersWith(b)) {
                        max = Math.max(max, a.length() * b.length());
                    }
                }
            }
        }
        
        return max;
    }
    
    class Word {
        String word;
        int[] freq = new int[32];
        
        Word(String word) {
            this.word = word;
            for (char c: word.toCharArray()) {
                freq[c - 'a']++;
            }
        }
        
        int length() {
            return word.length();
        }
        
        boolean sharesCommonLettersWith(Word other) {
            int sum = 0;
            for (int i = 0; i < 32; i++) {
                sum += this.freq[i] * other.freq[i];
            }
            
            return sum != 0;
        }
    }
}