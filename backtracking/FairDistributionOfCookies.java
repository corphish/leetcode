// https://leetcode.com/problems/fair-distribution-of-cookies
class Solution {
    int maxSession = Integer.MAX_VALUE;

    public int distributeCookies(int[] cookies, int k) {
        int n = cookies.length, upper = 0, dist[][] = new int[k][n - (k - 1)]; 
        Arrays.sort(cookies);
        for (int i = n/2 ; i < n; i++) {
            upper += cookies[i];
        }
        gen(cookies, 0, upper, dist);
        return maxSession;
    }

    void gen(int[] arr, int x, int upper, int[][] dist) {
        if (x == arr.length) {
            analyse(dist);
            return;
        }

        for (int i = 0; i < dist.length; i++) {
            int ix = -1, sum = 0;
            for (int j = 0; j < dist[i].length; j++) {
                if (sum > upper) {
                    break;
                }
                if (dist[i][j] == 0) {
                    ix = j;
                    break;
                } else {
                    sum += dist[i][j];
                }
            }

            if (ix != -1) {
                dist[i][ix] = arr[x];
                gen(arr, x + 1, upper, dist);
                dist[i][ix] = 0;
            }
        }
    }

    void analyse(int[][] dist) {
        int min = Integer.MAX_VALUE, max = 0;
        for (int[] d: dist) {
            int dSum = 0;
            for (int x: d) {
                dSum += x;
            }

            min = Math.min(min, dSum);
            max = Math.max(max, dSum);
        }

        if (min == 0) return;
        maxSession = Math.min(max, maxSession);
    }
}