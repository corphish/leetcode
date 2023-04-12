// https://leetcode.com/problems/successful-pairs-of-spells-and-potions
class Solution {
    public int[] successfulPairs(int[] spells, int[] potionsArray, long success) {
        long[] potions = Arrays.stream(potionsArray).sorted().mapToLong(x -> x).toArray();
        int[] res = new int[spells.length];

        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < potions.length; i++) {
            if (!map.containsKey(potions[i])) {
                map.put(potions[i], i);
            }
        }

        for (int i = 0; i < res.length; i++) {
            if (spells[i] == 0) continue;
            long factor = (success % spells[i] == 0 ? success/spells[i] : success/spells[i] + 1);
            int ix = map.containsKey(factor) ? map.get(factor) : Arrays.binarySearch(potions, factor);
            if (ix < 0) {
                ix = -ix - 1;
            }
            
            res[i] = potions.length - ix;
        }

        return res;
    }
}