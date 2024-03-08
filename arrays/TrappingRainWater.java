// https://leetcode.com/problems/trapping-rain-water
class Solution {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0, max = 0;
        for (int x : height) {
            if (stack.isEmpty()) {
                stack.push(x);
                max = x;
            } else {
                if (x < max) {
                    stack.push(x);
                } else {
                    while (!stack.isEmpty()) {
                        sum += max - stack.pop();
                    }

                    max = x;
                    stack.push(x);
                }
            }
        }

        Stack<Integer> another = new Stack<>();
        max = 0;
        while (!stack.isEmpty()) {
            int x = stack.pop();
            if (another.isEmpty()) {
                max = x;
                another.push(x);
            } else {
                if (x < max) {
                    another.push(x);
                } else {
                    while (!another.isEmpty()) {
                        sum += max - another.pop();
                    }

                    max = x;
                    another.push(x);
                }
            }
        }

        return sum;
    }
}