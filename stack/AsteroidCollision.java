// https://leetcode.com/problems/asteroid-collision
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> unused = new Stack<>();

        for (int x: asteroids) {
            if (stack.isEmpty()) {
                if (x > 0)
                    stack.push(x);
                else
                    unused.push(x);
            } else {
                if (sign(x) == sign(stack.peek())) {
                    stack.push(x);
                    continue;
                }

                while (sign(x) != sign(stack.peek())) {
                    int k = stack.pop();
                    if (Math.abs(k) > Math.abs(x)) {
                        stack.push(k);
                        break;
                    } else if (Math.abs(k) == Math.abs(x)) {
                        break;
                    } else {
                        if (stack.isEmpty()) {
                            if (x > 0)
                                stack.push(x);
                            else
                                unused.push(x);

                            break;
                        }
                    }
                }
            }
        }

        unused.addAll(stack);

        int[] res = new int[unused.size()];
        int i = 0;
        for (int x: unused) {
            res[i++] = x;
        }

        return res;
    }

    int sign(int x) {
        return x < 0 ? -1: 1;
    }
}