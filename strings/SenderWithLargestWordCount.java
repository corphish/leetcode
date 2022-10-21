// https://leetcode.com/problems/sender-with-largest-word-count
class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        Map<String, Integer> freq = new HashMap<>();
        
        String res = senders[0];
        int max = 0;
        
        for (int i = 0; i < senders.length; i++) {
            int wordCount = messages[i].trim().split(" ").length;
            int total = freq.getOrDefault(senders[i], 0) + wordCount;
            freq.put(senders[i], total);
            
            if (total > max) {
                max = total;
                res = senders[i];
            } else if (total == max) {
                if (res.compareTo(senders[i]) < 0) {
                    res = senders[i];
                }
            }
        }
        
        return res;
    }
}