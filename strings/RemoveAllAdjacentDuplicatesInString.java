// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string
class Solution {
    public String removeDuplicates(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c: s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.addLast(c);
            } else {
                if (stack.peekLast() == c) {
                    stack.removeLast();
                } else {
                    stack.addLast(c);
                }
            }
        }

        return stack.stream()
            .map(x -> "" + x)
            .collect(Collectors.joining());
    }
}