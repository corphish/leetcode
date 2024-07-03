// https://leetcode.com/problems/word-search
class Solution {
    public boolean exist(char[][] board, String word) {
        // First letter
        char f = word.charAt(0);
        int i = 0, j = 0;
        boolean firstFound = false;
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (; i < board.length; i++) {
            for (j = 0; j < board[0].length; j++) {
                if (board[i][j] == f) {
                    boolean x = exist(board, word, visited, i, j);
                    if (x)
                        return true;
                }
            }
        }

        return false;
    }

    private boolean exist(char[][] board, String word, boolean[][] visited, int x, int y) {
        if (word.isEmpty()) {
            return true;
        }

        if (x < 0 || x >= board.length) {
            return false;
        }

        if (y < 0 || y >= board[0].length) {
            return false;
        }

        if (visited[x][y]) {
            return false;
        }

        char f = word.charAt(0);
        if (board[x][y] != f) {
            return false;
        }

        visited[x][y] = true;

        boolean a = exist(board, word.substring(1), visited, x - 1, y);
        boolean b = exist(board, word.substring(1), visited, x + 1, y);
        boolean c = exist(board, word.substring(1), visited, x, y - 1);
        boolean d = exist(board, word.substring(1), visited, x, y + 1);

        visited[x][y] = false;

        return a || b || c || d;
    }
}