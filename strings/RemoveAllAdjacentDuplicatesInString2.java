// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii
class Solution {
    public String removeDuplicates(String s, int k) {
        // This stack will store upto k equal characters.
        // Once this stack has k equal characters, it will be emptied.
        // Then from another (store) stack, equal characters will be brought in.
        Deque<Character> matchStack = new ArrayDeque<>();
        
        // Storage stack
        Deque<Character> storeStack = new ArrayDeque<>();

        for (char c: s.toCharArray()) {
            if (matchStack.isEmpty()) {
                matchStack.addLast(c);
            } else {
                if (matchStack.peekLast() == c) {
                    if (matchStack.size() == k - 1) {
                        // We have k adjactent equal characters
                        matchStack.clear();

                        // Bring the equal characters from store stack.
                        // count is a check variable, ideally there should not be any consecutive equal
                        // characters in storeStack of length k.
                        int count = 0;
                        while (!storeStack.isEmpty() && count < k) {
                            if (matchStack.isEmpty() || matchStack.peekLast() == storeStack.peekLast()) {
                                matchStack.addLast(storeStack.removeLast());
                                count++;
                            } else {
                                break;
                            }
                        }
                    } else {
                        matchStack.addLast(c);
                    }
                } else {
                    // Clear match stack, and transfer all to store
                    storeStack.addAll(matchStack);
                    matchStack.clear();
                    matchStack.addLast(c);
                }
            }
        }

        if (!matchStack.isEmpty()) {
            storeStack.addAll(matchStack);
        }

        return storeStack.stream()
                .map(x -> "" + x)
                .collect(Collectors.joining());
    }
}