import java.util.Arrays;

class KthElementInSortedMatrix {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 0; i < 100; i++) {
            int n = 2 + ((int) (Math.random() * 10));
            int[][] matrix = generateSortedMatrix(n);
            int k = (int) (Math.random() * n * n);

            if (isValid(matrix)) {
                kthSmallest(matrix, k);
                count++;
            }
        }
        
        System.out.println("Simulated: " + count);
    }

    static int[][] generateSortedMatrix(int n) {
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            int base = (i == 0 ? 0 : Math.max(matrix[i - 1][i], matrix[i][i - 1])) + ((int) (Math.random() * 100));
            matrix[i][i] = base;

            // Fill row
            for (int j = i + 1; j < n; j++) {
                matrix[i][j] = matrix[i][j - 1] + ((int) (Math.random() * 100));
            }

            // Fill column
            for (int j = i + 1; j < n; j++) {
                matrix[j][i] = matrix[j - 1][i] + ((int) (Math.random() * 100));
            }
        }

        return matrix;
    }

    static void print(int[][] matrix) {
        for (int[] row: matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    static boolean isValid(int[][] matrix) {
        int n = matrix.length;

        // Check row
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] < matrix[i][j - 1]) {
                    return false;
                }
            }
        }

        // Check column
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[j][i] < matrix[j - 1][i]) {
                    return false;
                }
            }
        }

        return true;
    }

    static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int[] pointers = new int[n];
        
        int min = matrix[0][0];
        int resI = -1, resJ = -1, t = k;
        
        while (t-- > 0) {
            int pIndex = -1, pMin = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (pointers[i] < n && matrix[i][pointers[i]] < pMin) {
                    pMin = matrix[i][pointers[i]];
                    pIndex = i;
                }
            }
            
            min = pMin;
            pointers[pIndex]++;

            resI = pIndex;
            resJ = pointers[pIndex] - 1;
            
            //System.out.println(Arrays.toString(pointers));
        }

        System.out.printf("k=%d, n=%d, i=%d, j=%d, k/n=%d\n", k, n, resI, resJ, k/n);
        
        return min;
    }
}