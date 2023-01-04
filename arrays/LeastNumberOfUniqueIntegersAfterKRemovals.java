// https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/
class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x: arr) freq.put(x, freq.getOrDefault(x, 0) + 1);

        List<Frequency<Integer>> freqList = Frequency.fromMap(freq);
        Collections.sort(freqList);
        for (int i = 0; i < freqList.size(); i++) {
            var e = freqList.get(i);
            if (e.canFullyConsume(k)) {
                k -= e.freq;
                e.consume();
            } else {
                e.consume(k);
                if (e.freq == 0) {
                    return freqList.size() - i - 1;
                } else {
                    return freqList.size() - i;
                }
            }
        }

        return 0;
    }

    static final class Frequency<T> implements Comparable<Frequency<T>> {
        T val;
        int freq;

        Frequency(T val, int freq) {
            this.val = val;
            this.freq = freq;
        }

        void consume(int n) {
            freq -= n;
            if (freq < 0) freq = 0;
        }

        void consume() {
            freq = 0;
        }

        boolean canFullyConsume(int k) {
            return freq <= k;
        }

        public int compareTo(Frequency other) {
            return this.freq - other.freq;
        }

        public String toString() {
            return "{val=" + val + ", freq=" + freq + "}";
        }

        static <E> List<Frequency<E>> fromMap(Map<E, Integer> freq) {
            List<Frequency<E>> list = new ArrayList<>();
            for (var e: freq.entrySet()) {
                list.add(new Frequency(e.getKey(), e.getValue()));
            }

            return list;
        }
    }
}