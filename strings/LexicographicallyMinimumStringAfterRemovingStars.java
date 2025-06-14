// https://leetcode.com/problems/lexicographically-minimum-string-after-removing-stars
class Solution {
    public String clearStars(String s) {
        TreeMap<Character, Stack<Integer>> map = new TreeMap<>();
        Set<Integer> deleted = new HashSet<>();
        int i = 0;

        for (char c: s.toCharArray()) {
            if (c != '*') {
                map.computeIfAbsent(c, x -> new Stack<>()).push(i);
            } else {
                if (!map.isEmpty()) {
                    char key = map.firstKey();
                    Stack<Integer> st = map.firstEntry().getValue();
                    deleted.add(st.pop());
                    if (st.isEmpty()) {
                        map.remove(key);
                    }
                    deleted.add(i);
                }
            }

            i += 1;
        }

        StringBuilder sb = new StringBuilder();
        i = 0;

        for (char c: s.toCharArray()) {
            if (!deleted.contains(i)) {
                sb.append(c);
            }

            i += 1;
        }

        return sb.toString();
    }
}