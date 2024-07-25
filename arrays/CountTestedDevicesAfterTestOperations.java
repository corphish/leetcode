// https://leetcode.com/problems/count-tested-devices-after-test-operations/
class Solution {
    public int countTestedDevices(int[] arr) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                for (int j = i + 1; j < arr.length; j++) {
                    arr[j] -= 1;
                }

                count += 1;
            }
        }

        return count;
    }
}