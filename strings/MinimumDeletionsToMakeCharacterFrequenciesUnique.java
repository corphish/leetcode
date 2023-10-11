// https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique
class Solution {
    public int minDeletions(String s) {
        int[] freq = new int[32];
        boolean[] b = new boolean[s.length() + 1];
        int deletions = 0, max = 0;
        List<Integer> queue = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        
        for (char c: s.toCharArray()) {
            freq[c - 'a']++;
        }
        
        for (int x: freq) {
            if (x > 0) {
                b[x] = true;
            }
            
            max = Math.max(max, x);
        }
        
        for (int i = 1; i <= max; i++) {
            if (!b[i]) {
                queue.add(i);
            }
        }
        
        Arrays.sort(freq);
        
        for (int i = 31; i >= 0; i--) {
            int x = freq[i];
            if (x != 0) {
                if (!set.add(x)) {
                    if (queue.isEmpty()) {
                        deletions += x;
                    } else {
                        int y = -(Collections.binarySearch(queue, x)) - 2;
                        if (y >= 0) {
                            deletions += x - queue.get(y);
                            queue.remove(y);
                        } else
                            deletions += x;
                    }
                }
            }
        }
        
        return deletions;
    }
}