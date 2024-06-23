// https://leetcode.com/problems/taking-maximum-energy-from-the-mystic-dungeon/
class Solution {
    final int MIN = -1000000000;

    public int maximumEnergy(int[] energy, int k) {
        int max = MIN;

        for (int i = Math.min(k, energy.length - k); i < energy.length; i++) {
            if (i >= k) {
                energy[i] = Math.max(energy[i], energy[i] + energy[i - k]);
            }

            if (i >= energy.length - k) {
                max = Math.max(max, energy[i]);
            }
        }

        return max;
    }
}