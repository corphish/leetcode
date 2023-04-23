// https://leetcode.com/problems/largest-values-from-labels/
class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int n = values.length;
        Item[] items = new Item[n];

        for (int i = 0; i < n; i++) {
            items[i] = new Item(values[i], labels[i]);
        }

        Arrays.sort(items);
        Map<Integer, Integer> usage = new HashMap<>();
        int max = 0;

        for (int i = 0; i < n && numWanted > 0; i++) {
            int label = items[i].label;
            if (usage.getOrDefault(label, 0) == useLimit) {
                continue;
            }

            max += items[i].value;
            usage.put(label, usage.getOrDefault(label, 0) + 1);
            numWanted -= 1;
        }

        return max;
    }

    class Item implements Comparable<Item> {
        int value, label;

        Item(int value, int label) {
            this.value = value;
            this.label = label;
        }

        public int compareTo(Item other) {
            return other.value - this.value;
        }
    }
}