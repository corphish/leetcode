// https://leetcode.com/problems/minimum-number-of-moves-to-make-palindrome
class Solution {
    public int minMovesToMakePalindrome(String s) {
        char[] arr = s.toCharArray();
        int count = 0;
        boolean singleCharMoved = false;

        for (int i = 0; i < arr.length/2; i++) {
            // Find the last position of arr[i] within [i + 1, arr.length - 1 - i]
            char first = arr[i];
            int lastIndex = -1;
            for (int j = arr.length - 1 - i; j > i; j--) {
                if (arr[j] == arr[i]) {
                    lastIndex = j;
                    break;
                }
            }

            // If there is no last index for this, we move it to middle.
            int move = arr.length - 1 - i;
            int start = lastIndex + 1;
            if (lastIndex == -1) {
                move = arr.length/2;
                start = i + 1;
            }

            // Swap the lastIndex one by one to arr.length - 1 - i
            for (int j = start; j <= move; j++) {
                char temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
                count += lastIndex == -1 && singleCharMoved ? -1 : 1;
            }

            if (lastIndex == -1) {
                i -= 1;
                singleCharMoved = true;
            }
        }

        return count;
    }
}