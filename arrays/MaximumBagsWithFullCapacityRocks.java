// https://leetcode.com/problems/maximum-bags-with-full-capacity-of-rocks/
class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        List<Bag> list = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < capacity.length; i++) {
            list.add(new Bag(capacity[i], rocks[i]));
        }

        Collections.sort(list);
        for (Bag bag: list) {
            if (additionalRocks > 0 && additionalRocks >= bag.remaining()) {
                additionalRocks -= bag.remaining();
                count++;
            } else {
                break;
            }
        }

        return count;
    }

    class Bag implements Comparable<Bag> {
        int capacity, rocks;

        Bag(int capacity, int rocks) {
            this.capacity = capacity;
            this.rocks = rocks;
        }

        int remaining() {
            return capacity - rocks;
        }

        public int compareTo(Bag other) {
            return this.remaining() - other.remaining();
        }
    }
}