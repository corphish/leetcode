// https://leetcode.com/problems/reorganize-string/
class Solution {
    public String reorganizeString(String s) {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Frequency<Character>> queue = new PriorityQueue<>();
        int[] freq = new int[26];

        for (char c: s.toCharArray()) {
            freq[c - 'a'] += 1;
        }

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0)
                queue.add(new Frequency(freq[i], (char) (i + 'a')));
        }

        char last = '-';

        while (!queue.isEmpty()) {
            Frequency<Character> f = queue.poll();
            char ch = f.value;

            if (ch == last) {
                if (queue.isEmpty()) {
                    return "";
                } else {
                    Frequency<Character> g = queue.poll();
                    sb.append(g.value);
                    g.decrease();
                    if (!g.isOver()) {
                        queue.add(g);
                    }

                    last = g.value;
                    queue.add(f);
                }
            } else {
                sb.append(ch);
                f.decrease();
                last = ch;
                if (!f.isOver()) {
                    queue.add(f);
                }
            }
        }

        return sb.toString();
    }

    class Frequency<T> implements Comparable<Frequency<T>> {
        int freq;
        final T value;

        Frequency(int freq, T value) {
            this.freq = freq;
            this.value = value;
        }

        void decrease() {
            this.freq -= 1;
        }

        boolean isOver() {
            return this.freq == 0;
        }

        @Override
        public int compareTo(Frequency<T> other) {
            return other.freq - this.freq;
        }
    }
}