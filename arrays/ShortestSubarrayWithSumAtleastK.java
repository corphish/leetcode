// https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k
class Solution {
    public int shortestSubarray(int[] arr, int k) {
        long[] prefix = new long[arr.length];
        for (int i = 0; i < prefix.length; i++) {
            if (arr[i] >= k) {
                return 1;
            }

            if (i == 0) {
                prefix[i] = arr[i];
            } else {
                prefix[i] = prefix[i - 1] + arr[i];
            }
        }

        TreeSet<Data> set = new TreeSet<>();
        set.add(new Data(0, -1));
        int min = arr.length + 1;

        for (int i = 0; i < prefix.length; i++) {
            while (prefix[i] - set.first().val >= k) {
                Data f = set.pollFirst();
                min = Math.min(min, i - f.index);
            }

            set.add(new Data(prefix[i], i));
        }

        return min == arr.length + 1 ? -1 : min;
    }

    class Data implements Comparable<Data> {
        long val;
        int index;

        Data(long val, int index) {
            this.val = val;
            this.index = index;
        }

        public int compareTo(Data other) {
            return this.val == other.val ? other.index - this.index : Long.compare(this.val, other.val);
        }
    }
}