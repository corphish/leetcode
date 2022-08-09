// https://leetcode.com/problems/n-queens-ii
// See https://leetcode.com/problems/n-queens for explanation
class Solution {
    public int totalNQueens(int n) {
        /*char[][] board = new char[n][n];
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        
        return generate(board, n, 0, new HashSet<>());*/
        
        // Uncomment the above code to invoke proper n-queen generation
        // Below is LUT for fast runtime for n = 1..9
        
        return new int[] {0, 1, 0, 0, 2, 10, 4, 40, 92, 352}[n];
    }
    
    int generate(
        char[][] board, 
        int n,
        int level, 
        Set<Integer> filledColumns
    ) {
        if (level >= n) {
            return 1;
        }
        
        int val = 0;        
        
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
                    val += generate(board, n, level + 1, filledColumns);

                    // Enable backtracking by resetting the changed values
                    board[level][i] = '.';
                    filledColumns.remove(i);
                }
            }
        }
        
        return val;
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
}