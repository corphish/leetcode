// https://leetcode.com/problems/determine-if-two-strings-are-close
class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        word1 = new String(arr1);
        word2 = new String(arr2);

        if (word1.equals(word2)) {
            return true;
        }

        Map<Character, Integer> freq1 = new TreeMap<>();
        Map<Character, Integer> freq2 = new TreeMap<>();

        for (char c: arr1) freq1.put(c, freq1.getOrDefault(c, 0) + 1);
        for (char c: arr2) freq2.put(c, freq2.getOrDefault(c, 0) + 1);

        if (!freq1.keySet().equals(freq2.keySet())) {
            return false;
        }

        int[] item1 = new int[freq1.size()];
        int[] item2 = new int[freq2.size()];
        
        int i = 0;
        for (var e: freq1.entrySet()) {
            item1[i++] = e.getValue();
        }

        i = 0;
        for (var e: freq2.entrySet()) {
            item2[i++] = e.getValue();
        }

        Arrays.sort(item1);
        Arrays.sort(item2);

        return Arrays.equals(item1, item2);
    }
}