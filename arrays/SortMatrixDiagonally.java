// https://leetcode.com/problems/sort-the-matrix-diagonally/
class Solution {
    public int[][] diagonalSort(int[][] mat) {
        List<Diagonal> list = new ArrayList<>();
        
        // Add rows except (0, 0)
        for (int j = 1; j < mat[0].length; j++) {
            list.add(Diagonal.from(mat, 0, j));
        }
        
        // Add column except (0, 0)
        for (int i = 1; i < mat.length; i++) {
            list.add(Diagonal.from(mat, i, 0));
        }
        
        // Add (0, 0)
        list.add(Diagonal.from(mat, 0, 0));
        
        for (Diagonal d: list) {
            d.populate(mat);
        }
        
        return mat;
    }
    
    static class Diagonal {
        private int startX, startY;
        private List<Integer> elements = new ArrayList<>();
        
        private Diagonal(int x, int y) {
            this.startX = x;
            this.startY = y;
        }
        
        private Diagonal() {}
        
        private void add(int x) {
            elements.add(x);
        }
        
        private void sort() {
            Collections.sort(elements);
        }
        
        void populate(int[][] mat) {
            this.sort();
            
            for (int i = startX, j = startY, k = 0;
                 i < mat.length && j < mat[0].length;
                 i++, j++, k++) {
                mat[i][j] = elements.get(k);
            }
        }
        
        static final Diagonal from(int[][] mat, int startX, int startY) {
            Diagonal d = new Diagonal(startX, startY);
            for (int i = startX, j = startY;
                 i < mat.length && j < mat[0].length;
                 i++, j++) {
                d.add(mat[i][j]);
            }
            
            return d;
        }
    }
}