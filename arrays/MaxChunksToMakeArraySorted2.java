// https://leetcode.com/problems/max-chunks-to-make-sorted-ii/
class Solution {
    public int maxChunksToSorted(int[] arr) {
        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        normalise(arr, sorted);

        int count = 0;
        int[] freqA = new int[sorted[sorted.length - 1] + 1];
        int[] freqB = new int[sorted[sorted.length - 1] + 1];

        for (int i = 0; i < arr.length; i++) {
            freqA[arr[i]] += 1;
            freqB[sorted[i]] += 1;

            boolean equals = true;
            for (int j = 0; j < freqA.length; j++) {
                if (freqA[j] != freqB[j]) {
                    equals = false;
                    break;
                }
            }

            if (equals) {
                count += 1;
                for (int j = 0; j < freqA.length; j++) {
                    freqA[j] = 0;
                    freqB[j] = 0;
                }
            }
        }

        return count;
    }

    void normalise(int[] arr, int[] sorted) {
        int start = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int x: sorted) {
            if (!map.containsKey(x)) {
                map.put(x, start);
                start += 1;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
            sorted[i] = map.get(sorted[i]);
        }
    }
}