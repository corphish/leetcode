// Group Anagrams
// Given an array of strings strs, group the anagrams together. You can return the answer in any order.

// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
class Solution {
    // Maintain a map, where key will be sorted form of a word, value will be the list of words whose sorted form
    // is the key.
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> m = new HashMap<>();
        for (String x: strs) {
            char[] c = x.toCharArray();
            Arrays.sort(c);
            List<String> l = m.get(Arrays.toString(c));
            if (l == null) l = new ArrayList<>();
            l.add(x);
            m.put(Arrays.toString(c), l);
        }
        
        return new ArrayList<>(m.values());
    }
}