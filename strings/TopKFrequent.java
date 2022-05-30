// https://leetcode.com/problems/top-k-frequent-words
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();
        Map<Integer, Set<String>> revFreq = new TreeMap<>(Collections.reverseOrder());
        
        for (String word: words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
        
        for (var e: freq.entrySet()) {
            int f = e.getValue();
            Set<String> set = revFreq.getOrDefault(f, new TreeSet<>());
            set.add(e.getKey());
            revFreq.put(f, set);
        }
        
        List<String> res = new ArrayList<>();
        for (var e: revFreq.entrySet()) {
            for (String word: e.getValue()) {
                res.add(word);
                k--;
                if (k == 0) break;
            }
            if (k == 0) break;
        }
        
        return res;
    }
}