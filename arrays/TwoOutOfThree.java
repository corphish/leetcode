// https://leetcode.com/problems/two-out-of-three/
class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> res = new ArrayList<>();

        for (int i = 1; i <= 100; i++) {
            int count = 0;

            for (int x : nums1) {
                if (x == i) {
                    count += 1;
                    break;
                }
            }

            for (int x : nums2) {
                if (x == i) {
                    count += 1;
                    break;
                }
            }

            for (int x : nums3) {
                if (x == i) {
                    count += 1;
                    break;
                }
            }

            if (count >= 2) {
                res.add(i);
            }
        }

        return res;
    }
}