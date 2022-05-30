// https://leetcode.com/problems/game-of-life
class Solution {
    public void gameOfLife(int[][] board) {
        int[][] res = new int[board.length][board[0].length];
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                res[i][j] = determine(board, i, j);
            }
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = res[i][j];
            }
        }
    }
    
    int safeGet(int[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return -1;
        }
        
        return board[i][j];
    }
    
    int determine(int[][] board, int i, int j) {
        int[] state = {0, 0, 0};
        
        state[safeGet(board, i - 1, j - 1) + 1]++;
        state[safeGet(board, i - 1, j) + 1]++;
        state[safeGet(board, i - 1, j + 1) + 1]++;
        state[safeGet(board, i, j - 1) + 1]++;
        state[safeGet(board, i, j + 1) + 1]++;
        state[safeGet(board, i + 1, j - 1) + 1]++;
        state[safeGet(board, i + 1, j) + 1]++;
        state[safeGet(board, i + 1, j + 1) + 1]++;
        
        int curr = safeGet(board, i, j);
        
        if (curr == 1) {
            if (state[2] < 2 || state[2] > 3) {
                return 0;
            } else {
                return 1;
            }
        } else {
            if (state[2] == 3) {
                return 1;
            } else {
                return 0;
            }
        }  
    }
}