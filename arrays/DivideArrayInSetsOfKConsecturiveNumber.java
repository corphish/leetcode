// https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers
class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) {
            return false;
        }

        Arrays.sort(nums);

        int id = 0;
        Map<Integer, Stack<Group>> groups = new HashMap<>();

        for (int x: nums) {
            // Check if there is any group that expects x
            // Expected value is also the key of the map.
            Stack<Group> group = groups.get(x);
            if (group == null) {
                Group g = new Group(id++, k, x);
                if (!g.isComplete())
                    groups.computeIfAbsent(x + 1, y -> new Stack<>()).push(g);
            } else {
                Group g = group.pop();
                g.add(x);
                if (!g.isComplete())
                    groups.computeIfAbsent(x + 1, y -> new Stack<>()).push(g);

                if (group.isEmpty()) {
                    groups.remove(x);
                }
            }
        }

        return groups.isEmpty();
    }

    class Group {
        int id, k, last;
        int count = 1;

        Group(int id, int k, int last) {
            this.id = id;
            this.k = k;
            this.last = last;
        }

        int expects() {
            return last + 1;
        }

        boolean isComplete() {
            return count >= k;
        }

        void add(int x) {
            this.last = x;
            this.count += 1;
        }

        public String toString() {
            return String.format("Group(id=%d, last=%d, count=%d)", id, last, count);
        }
    }
}