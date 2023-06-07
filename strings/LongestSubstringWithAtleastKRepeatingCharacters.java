// https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
class Solution {
    public int longestSubstring(String s, int k) {
        int[] freq = new int[26];
        char[] arr = s.toCharArray();
        int maxFreq = 0, max = 0;
        for (char c: arr) {
            freq[c - 'a']++;
            maxFreq = Math.max(maxFreq, freq[c - 'a']);
        }

        if (maxFreq < k) return 0;

        int[] tempFreq = new int[26];
        int start = -1;
        boolean isRecording = false;
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (freq[c - 'a'] >= k) {
                if (!isRecording) {
                    isRecording = true;
                    start = i;
                }

                tempFreq[c - 'a']++;
            } 
            if (freq[c - 'a'] < k || i == arr.length - 1) {
                if (!isRecording) continue;
                int end = i - (freq[c - 'a'] >= k ? 0 : 1);
                isRecording = false;

                // Check for validity of tempFreq
                boolean isValid = true;
                boolean partiallyValid = false;
                for (int x: tempFreq) {
                    if (x != 0 && x < k) {
                        isValid = false;
                    } else if (x != 0 && x >= k) {
                        partiallyValid = true;
                    }
                }

                if (isValid) {
                    int len = end - start + 1;
                    if (len > max) {
                        max = len;
                    }
                } else if (partiallyValid) {
                    int len = longestSubstring(s.substring(start, end + 1), k);
                    if (len > max) {
                        max = len;
                    }
                }

                for (int j = 0; j < 26; j++) {
                    tempFreq[j] = 0;
                }
            }
        }

        return max;
    }
}