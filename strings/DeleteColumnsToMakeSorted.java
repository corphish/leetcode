// https://leetcode.com/problems/delete-columns-to-make-sorted/
class Solution {
    public int minDeletionSize(String[] strs) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < strs[0].length(); i++) {
            StringBuilder sb = new StringBuilder();
            for (String s: strs) {
                sb.append(s.charAt(i));
            }

            list.add(sb.toString());
        }

        int k = 0;
        for (String s: list) {
            char[] arr = s.toCharArray(), exp = arr.clone();
            Arrays.sort(exp);

            if (!Arrays.equals(exp, arr)) {
                k++;
            }
        }

        return k;
    }
}