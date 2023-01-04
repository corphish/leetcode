// https://leetcode.com/problems/daily-temperatures
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<IndexedValue> stack = new Stack<>();
        int n = temperatures.length, res[] = new int[n];

        for (int i = 0; i < n; i++) {
            if (stack.isEmpty()) {
                stack.push(new IndexedValue(temperatures[i], i));
            } else {
                while (!stack.isEmpty()) {
                    if (temperatures[i] > stack.peek().value) {
                        IndexedValue iv = stack.pop();
                        res[iv.index] = i - iv.index;
                    } else {
                        break;
                    }
                }
                stack.push(new IndexedValue(temperatures[i], i));
            }
        }

        return res;
    }

    class IndexedValue {
        int value, index;

        IndexedValue(int value, int index) {
            this.value = value;
            this.index = index;
        }

        public String toString() {
            return "(" + value + ", " + index + ")";
        }
    }
}