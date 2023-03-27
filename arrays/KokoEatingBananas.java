// https://leetcode.com/problems/koko-eating-bananas/
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);

        int last = piles[piles.length - 1];
        int upper = last, lower = 0, lastPossibleRes = -1;
        Map<Integer, Boolean> map = new HashMap<>();

        while (lower <= upper) {
            int mid = (lower + upper)/2;
            boolean x = canEatAll(piles, mid, h);

            map.put(mid, x);

            if (x) {
                upper = mid - 1;
                if (map.containsKey(upper) && !map.get(upper)) {
                    return mid;
                }

                lastPossibleRes = mid;
            } else {
                lower = mid + 1;
                if (map.containsKey(lower) && map.get(lower)) {
                    return lower;
                }

                if (lower > upper && lastPossibleRes == -1) {
                    upper *= 2;
                }
            }
        }

        return lastPossibleRes;
    }

    public boolean canEatAll(int[] piles, int speed, int h) {
        int time = 0;
        for (int x: piles) {
            time += Math.ceil((x * 1.0)/speed);
        }
        
        return time <= h;
    }
}