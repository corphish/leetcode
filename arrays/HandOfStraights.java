// https://leetcode.com/problems/hand-of-straights
class Solution {
    public boolean isNStraightHand(int[] hand, int k) {
        if (hand.length % k != 0) {
            return false;
        }

        Map<Integer, Integer> freq = new TreeMap<>();
        for (int x: hand) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        for (int i = 0; i < hand.length; i += k) {
            int last = -1;
            int session = 0;
            Set<Integer> group = new HashSet<>();

            for (var e: freq.entrySet()) {
                if (e.getValue() == 0) continue;
                if (last == -1 || e.getKey() - last == 1) {
                    last = e.getKey();
                    group.add(last);
                } else {
                    return false;
                }

                session++;
                if (session == k) {
                    break;
                }
            }

            if (session < k) return false;

            for (int x: group) {
                freq.put(x, freq.get(x) - 1);
            }
        }

        return true;
    }
}