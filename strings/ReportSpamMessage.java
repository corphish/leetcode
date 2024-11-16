// https://leetcode.com/problems/report-spam-message/
class Solution {
    public boolean reportSpam(String[] message, String[] bannedWords) {
        Set<String> set = Arrays.stream(bannedWords).collect(Collectors.toSet());
        int count = 0;

        for (String word: message) {
            if (set.contains(word)) {
                count += 1;
            }
        }

        return count > 1;
    }
}