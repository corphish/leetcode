// https://leetcode.com/problems/replace-words
class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] words = sentence.split(" ");
        Matcher m = new Matcher(dictionary);
        StringBuilder res = new StringBuilder();
        
        for (int i = 0; i < words.length; i++) {
            String root = m.getRoot(words[i]);
            res.append(root);
            res.append(" ");
        }
        
        return res.toString().trim();
    }
    
    class Matcher {
        Set<String> words;
        TreeSet<Integer> wordSizes;
        
        Matcher(List<String> dictionary) {
            words = new HashSet<>();
            wordSizes = new TreeSet<>();
            
            for (String word: dictionary) {
                words.add(word);
                wordSizes.add(word.length());
            }
        }
        
        String getRoot(String word) {
            int minLength = wordSizes.first();
            if (word.length() < minLength) return word;
            
            StringBuilder sb = new StringBuilder();
            int i = 0;
            for (int size: wordSizes) {
                for (; i < size && i < word.length(); i++) {
                    sb.append(word.charAt(i));
                }
                
                String built = sb.toString();
                if (words.contains(built)) {
                    return built;
                }
            }
            
            return word;
        }
    }
}