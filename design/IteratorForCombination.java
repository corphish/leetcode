// https://leetcode.com/problems/iterator-for-combination
class CombinationIterator {

    Queue<String> queue = new ArrayDeque<>();

    public CombinationIterator(String characters, int combinationLength) {
        char[] letters = characters.toCharArray();
        Arrays.sort(letters);
        boolean[] used = new boolean[letters.length];
        char[] word = new char[combinationLength];
        fill(letters, word, 0, 0);
    }
    
    public String next() {
        return queue.poll();
    }
    
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    void fill(char[] letters, char[] word, int ix, int start) {
        if (ix >= word.length) {
            queue.add(new String(word));
            return;
        }

        for (int i = start; i < letters.length; i++) {
            word[ix] = letters[i];
            fill(letters, word, ix + 1, i + 1);
        }
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */