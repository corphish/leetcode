// https://leetcode.com/problems/design-spreadsheet
class Spreadsheet {

    int[][] arr;

    public Spreadsheet(int rows) {
        arr = new int[rows][26];
    }

    private int[] addr(String cell) {
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1)) - 1;

        return new int[] { row, col };
    }
    
    public void setCell(String cell, int value) {
        int[] addr = addr(cell);
        arr[addr[0]][addr[1]] = value;
    }
    
    public void resetCell(String cell) {
        int[] addr = addr(cell);
        arr[addr[0]][addr[1]] = 0;
    }
    
    public int getValue(String formula) {
        String[] parts = formula.substring(1).split("\\+");
        int sum = 0;

        for (String part: parts) {
            try {
                sum += Integer.parseInt(part);
            } catch (Exception e) {
                int[] addr = addr(part);
                sum += arr[addr[0]][addr[1]];
            }
        }

        return sum;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */