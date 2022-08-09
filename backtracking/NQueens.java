// https://leetcode.com/problems/n-queens
class Solution {
    // Logic:
    // 1. In each recursive call, we will place a queen at a particular row that we want.
    // 2. When we are placing at any position, we check if there is any queen in that column, as well as in any of its diagonal
    // 3. If no, we track the column we are placing.
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        
        generate(board, n, 0, new HashSet<>(), res);
        return res;
    }
    
    void generate(
        char[][] board, 
        int n,
        int level, 
        Set<Integer> filledColumns, 
        List<List<String>> res
    ) {
        if (level >= n) {
            res.add(generateSolution(board));
            return;
        }
        
        
        // Level is the row which we know is not filled
        
        for (int i = 0; i < n; i++) {
            // Check if this column is not filled
            if (!filledColumns.contains(i)) {
                // Column is not filled, we should check the upper diagonals
                // We can only check if the level is greater than 0.
                // Else if the level is 0 we can place it
                boolean isUnderAttackFromDiagonal = false;
                if (level == 0) {
                    isUnderAttackFromDiagonal = false;
                } else {
                    boolean ul = checkLeftDiagonal(board, n, level, i);
                    boolean ur = checkRightDiagonal(board, n, level, i);
                    
                    isUnderAttackFromDiagonal = !(ul && ur);
                }
                
                if (!isUnderAttackFromDiagonal) {
                    // We can place it here
                    board[level][i] = 'Q';
                    filledColumns.add(i);

                    // Recursively solve for next rows
                    generate(board, n, level + 1, filledColumns, res);

                    // Enable backtracking by resetting the changed values
                    board[level][i] = '.';
                    filledColumns.remove(i);
                }
            }
        }
    }
    
    // Will return true if queen placed at x,y is not under attack from any other
    // queen left diagonally.
    boolean checkLeftDiagonal(char[][] board, int n, int x, int y) {
        boolean res = true;
        for (int i = 1; i < n; i++) {
            if (x - i >= 0 && y - i >= 0) {
                if (board[x - i][y - i] == 'Q') {
                    res = false;
                    break;
                }
            } else {
                break;
            }
        }
        
        return res;
    }
    
    // Will return true if queen placed at x,y is not under attack from any other
    // queen right diagonally.
    boolean checkRightDiagonal(char[][] board, int n, int x, int y) {
        boolean res = true;
        for (int i = 1; i < n; i++) {
            if (x - i >= 0 && y + i <= n - 1) {
                if (board[x - i][y + i] == 'Q') {
                    res = false;
                    break;
                }
            } else {
                break;
            }
        }
        
        return res;
    }
    
    List<String> generateSolution(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] row: board) {
            res.add(new String(row));
        }
        
        return res;
    }
}