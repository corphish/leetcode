// https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings
class Solution {
    public int maxUniqueSplit(String s) {
        return max(s, 0, new HashSet<>());
    }

    int max(
        String s,
        int i,
        Set<String> set
    ) {
        if (i >= s.length()) {
            return set.size();
        }

        int max = 0;
        for (int j = i + 1; j <= s.length(); j++) {
            String sub = s.substring(i, j);
            if (!set.contains(sub)) {
                set.add(sub);
                max = Math.max(max, max(s, j, set));
                set.remove(sub);
            }
        }

        return max;
    }
}