// https://leetcode.com/problems/finding-3-digit-even-numbers
class Solution {
    public int[] findEvenNumbers(int[] digits) {
        return IntStream.range(100, 1000)
                .filter(x -> x % 2 == 0 && canBeFormed(x, digits))
                .toArray();
    }

    boolean canBeFormed(int x, int[] digits) {
        boolean[] visited = new boolean[digits.length];
        for (; x > 0; x /= 10) {
            int digit = x % 10;
            boolean found = false;
            for (int i = 0; i < digits.length; i++) {
                if (digits[i] == digit && !visited[i]) {
                    visited[i] = true;
                    found = true;
                    break;
                }
            }

            if (!found) {
                return false;
            }
        }

        return true;
    }
}