// https://leetcode.com/problems/distant-barcodes
class Solution {
    public int[] rearrangeBarcodes(int[] arr) {
        int[] freq = new int[10001];
        int res[] = new int[arr.length], i = 0;
        for (int x: arr) freq[x]++;

        PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (i = 1; i < freq.length; i++) {
            if (freq[i] > 0)
                queue.add(new Pair<>(i, freq[i]));
        }

        int last = -1;
        i = 0;
        Pair<Integer, Integer> temp = null;
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> p = queue.poll();
            int key = p.getKey();
            if (key == last) {
                temp = p;
            } else {
                res[i++] = key;
                freq[key] -= 1;
                if (freq[key] > 0) {
                    queue.add(new Pair<>(key, freq[key]));
                }
                if (temp != null) {
                    queue.add(temp);
                    temp = null;
                }
                last = key;
            }
        }

        return res;
    }
}