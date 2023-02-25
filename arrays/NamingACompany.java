// https://leetcode.com/problems/naming-a-company/
class Solution {
    public long distinctNames(String[] ideas) {
        long res = 0;
        Map<Character, LetterGroup> map = new HashMap<>();

        // Build the letter group
        for (String idea: ideas) {
            char c = idea.charAt(0);
            String suffix = idea.substring(1);

            map.computeIfAbsent(c, x -> new LetterGroup(c)).addSuffix(suffix);
        }

        // Choose a letter
        for (int i = 0; i < 26; i++) {
            char a = (char) ('a' + i);

            // Discard if we have no ideas starting with this letter
            if (!map.containsKey(a)) continue;

            // Choose another letter, which is different from the previously chosen letter
            for (int j = 0; j < 26; j++) {
                char b = (char) ('a' + j);

                // Discard if they are same letter
                if (i == j) continue;

                // Discard if we have no ideas starting with this letter
                if (!map.containsKey(b)) continue;

                // Now, for each suffix supported by letter a, we will consider
                // all suffixes supported by letter b except the one we are checking
                LetterGroup group = map.get(b);
                int count = group.countExcluding(map.get(a).suffixSet());
                res += Math.max(0, count);
            }
        }

        return res;
    }

    class LetterGroup {
        // Letter that denotes this group.
        private final char c;

        // Suffixes held by this group
        private final Set<String> suffixSet = new HashSet<>();

        LetterGroup(char c) {
            this.c = c;
        }

        Set<String> suffixSet() {
            return suffixSet;
        }

        void addSuffix(String suffix) {
            suffixSet.add(suffix);
        }

        int countExcluding(Set<String> otherSuffixes) {
            Set<String> consider = new HashSet<>();
            Set<String> removed = new HashSet<>();

            consider.addAll(suffixSet);
            for (String suffix: otherSuffixes) {
                if (consider.contains(suffix) || removed.contains(suffix)) {
                    consider.remove(suffix);
                    removed.add(suffix);
                } else {
                    consider.add(suffix);
                }
            }

            int chosenFromA = 0;
            int chosenFromB = 0;

            for (String choice: consider) {
                if (suffixSet.contains(choice)) {
                    chosenFromA += 1;
                } else if (otherSuffixes.contains(choice)) {
                    chosenFromB += 1;
                }
            }

            return chosenFromA * chosenFromB;
        }
    }
}