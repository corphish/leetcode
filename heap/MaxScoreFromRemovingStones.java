// https://leetcode.com/problems/maximum-score-from-removing-stones
class Solution {
    // 1. This problem will be difficult to do with TreeSet as it can not hold unique values.
    // 2. So we maintain array [a, b, c], sorting them before we work with them.
    // 3. In each iteration, we check if arr[0] and arr[1] is 0 or not, if so, game is over.
    // 4. We then decrement the min and max values of the array (we can only decrement non zero values in array), and at the same time we increase score by 1
    public int maximumScore(int a, int b, int c) {
        int[] arr = new int[] {a, b, c};
        int score = 0;
        
        boolean canSelect = true;
        while (canSelect) {
            Arrays.sort(arr);
            if (arr[0] == 0 && arr[1] == 0) {
                // Game over
                break;
            }
            
            // Decrement min
            if (arr[0] == 0) {
                arr[1]--;
            } else {
                arr[0]--;
            }
            
            // Decrement max
            arr[2]--;
            
            // Increase score
            score++;
        }
        
        return score;
    }
}