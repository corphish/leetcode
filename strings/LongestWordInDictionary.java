//https://leetcode.com/problems/longest-word-in-dictionary
class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() == b.length() ? b.compareTo(a) : a.length() - b.length());
        Set<String> h = new HashSet<>();
        
        for (String word: words) {
            h.add(word);
        }
        
        for (int i = words.length - 1; i >= 0; i--) {
            StringBuilder sb = new StringBuilder();
            boolean r = true;
            for (char c: words[i].toCharArray()) {
                sb.append(c);
                if (!h.contains(sb.toString())) {
                    r = false;
                    break;
                }
            }
            
            if (r) {
                return words[i];
            }
        }
        
        return "";
    }
}