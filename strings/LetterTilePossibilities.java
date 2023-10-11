// https://leetcode.com/problems/letter-tile-possibilities
class Solution {
    public int numTilePossibilities(String tiles) {
        char[] res = new char[tiles.length()];
        Arrays.fill(res, ' ');
        boolean[] used = new boolean[tiles.length()];
        Set<String> acc = new HashSet<>();
        print(tiles.toCharArray(), res, 0, used, acc);
        return acc.size() - 1;
    }

    void print(char[] arr, char[] res, int i, boolean[] used, Set<String> acc) {
        if (i > res.length) {
            return;
        }
        acc.add(new String(res));

        for (int j = 0; j < arr.length; j++) {
            if (!used[j]) {
                used[j] = true;
                res[i] = arr[j];
                print(arr, res, i + 1, used, acc);
                res[i] = ' ';
                used[j] = false;
            }
        }
    }
}