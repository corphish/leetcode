// https://leetcode.com/problems/occurrences-after-bigram/
class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        List<String> res = new ArrayList<>();
        String[] p = text.split(" ");
        for (int i = 2; i < p.length; i++) {
            if (p[i - 2].equals(first) && p[i - 1].equals(second)) {
                res.add(p[i]);
            }
        }

        return res.toArray(new String[] {});
    }
}