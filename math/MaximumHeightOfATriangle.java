// https://leetcode.com/problems/maximum-height-of-a-triangle/
class Solution {
    public int maxHeightOfTriangle(int red, int blue) {
        return Math.max(
            height(red, blue),
            height(blue, red)
        );
    }

    int height(int c1, int c2) {
        // c1 goes in odd rows
        int oddCount = (int) Math.sqrt(c1);

        // c2 goes in even rows
        int evenCount = (int) ((-1 + Math.sqrt(1 + 4 * c2))/2);

        int count = 1;
        for (int i = 1; oddCount > 0 && evenCount > 0; count++, i++) {
            if (i % 2 == 1) {
                oddCount -= 1;
            } else {
                evenCount -= 1;
            }
        }

        return count;
    }
}