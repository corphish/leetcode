// https://leetcode.com/problems/maximize-the-confusion-of-an-exam
class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        char[] arr = answerKey.toCharArray();
        return Math.max(
            check(arr, k, 'T'),
            check(arr, k, 'F')
        );
    }

    int check(char[] arr, int k, char c) {
        // c = consecutive character we are trying to form
        int max = 0;
        int count = 0;
        int start = 0;
        Queue<Integer> queue = new ArrayDeque<>();

        // The window should have at most k characters that we will change
        // It can contain 0 characters that we will not change.
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != c) {
                if (count == k) {
                    start = queue.poll() + 1;
                } else {
                    count += 1;
                }

                queue.add(i);
            }

            max = Math.max(max, i - start + 1);
        }

        return max;
    }
}