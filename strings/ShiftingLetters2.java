// https://leetcode.com/problems/shifting-letters-ii
class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int[] arr = new int[s.length()];

        for (int[] x: shifts) {
            int d = x[2] == 0 ? -1 : 1;

            arr[x[0]] += d;

            if (x[1] + 1 < arr.length) {
                arr[x[1] + 1] -= d;
            }
        }

        for (int i = 1; i < arr.length; i++) {
            arr[i] += arr[i - 1];
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            int shifted = (s.charAt(i) - 'a' + (arr[i] % 26)) % 26;
            if (shifted < 0) shifted = 26 + shifted;
            sb.append((char) ('a' + shifted));
        }

        return sb.toString();
    }
}