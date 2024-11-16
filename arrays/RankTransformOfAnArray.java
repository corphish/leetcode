// https://leetcode.com/problems/rank-transform-of-an-array
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] sorted = arr.clone();
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(sorted);
        int k = 0;

        for (int x: sorted) {
            if (!map.containsKey(x)) {
                map.put(x, ++k);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }

        return arr;
    }
}