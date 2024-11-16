// https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists
class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();
        int[] ix = new int[k];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] res = { 0, Integer.MAX_VALUE/2 };
        int count = 0;
        int[][] arr = merge(nums);

        Arrays.fill(ix, Integer.MIN_VALUE);

        for (int i = 0; i < arr.length; i++) {
            int chosenList = arr[i][1];
            if (ix[chosenList] != Integer.MIN_VALUE) {
                int previouslyAdded = ix[chosenList];
                int currFreq = map.getOrDefault(previouslyAdded, 0);
                map.put(previouslyAdded, currFreq - 1);
                if (currFreq == 1) {
                    map.remove(previouslyAdded);
                }

                count -= 1;
            }

            int num = arr[i][0];
            map.put(num, map.getOrDefault(num, 0) + 1);
            ix[chosenList] = num;
            count += 1;

            if (count == k) {
                int a = map.firstKey(), b = map.lastKey();
                if (b - a < res[1] - res[0]) {
                    res[0] = a;
                    res[1] = b;
                }
            }
        }

        return res;
    }

    int[][] merge(List<List<Integer>> nums) {
        int count = 0, k = 0;
        PriorityQueue<Num> queue = new PriorityQueue<>();
        for (int i = 0; i < nums.size(); i++) {
            count += nums.get(i).size();
            queue.add(new Num(nums.get(i).get(0), i));
        }

        int[][] res = new int[count][2];
        int[] ix = new int[nums.size()];

        while (!queue.isEmpty()) {
            Num n = queue.poll();
            res[k][0] = n.num;
            res[k][1] = n.i;
            k += 1;
            ix[n.i] += 1;

            if (ix[n.i] < nums.get(n.i).size()) {
                queue.add(new Num(nums.get(n.i).get(ix[n.i]), n.i));
            }
        }

        return res;
    }

    class Num implements Comparable<Num> {
        int num, i;
        Num(int num, int i) {
            this.num = num;
            this.i = i;
        }

        public int compareTo(Num other) {
            return this.num == other.num ? this.i - other.i : this.num - other.num;
        }
    }
}