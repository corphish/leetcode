class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        k = k % (m * n);
        int[][] res = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                put(res, m, n, grid[i][j], i, j, k);
            }
        }
        
        List<List<Integer>> R = new ArrayList<>();
        for (int[] arr: res) {
            R.add(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        }
        
        return R;
    }
    
    void put(int[][] res, int m, int n, int val, int i, int j, int k) {
        int from = n * i + j;
        int to = (from + k) % (m * n);
        
        int tX = to/n;
        int tY = to % n;
        
        res[tX][tY] = val;
    }
}