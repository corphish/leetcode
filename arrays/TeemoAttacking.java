// https://leetcode.com/problems/teemo-attacking
class Solution {
    public int findPoisonedDuration(int[] arr, int duration) {
        int tot = duration, end = arr[0] + duration - 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= end) {
                tot -= end - arr[i] + 1;
                tot += duration;
            } else {
                tot += duration;
            }
            
            end = arr[i] + duration - 1;
        }
        
        return tot;
    }
}