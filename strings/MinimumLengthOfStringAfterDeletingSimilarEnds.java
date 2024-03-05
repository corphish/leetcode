// https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends
class Solution {
    public int minimumLength(String s) {
        int left = 0, right = s.length() - 1;
        char[] arr = s.toCharArray();

        if (s.length() == 1) {
            return 1;
        }
        
        while (left < right) {
            if (arr[left] == arr[right]) {
                char ch = arr[left];
                while (left <= right) {
                    if (arr[left] != ch && arr[right] != ch) {
                        break;
                    }

                    if (arr[left] == ch) {
                        left += 1;
                    }

                    if (arr[right] == ch) {
                        right -= 1;
                    }
                }
            } else {
                break;
            }
        }

        return Math.max(0, right - left + 1);
    }
}