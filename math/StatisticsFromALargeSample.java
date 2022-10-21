// https://leetcode.com/problems/statistics-from-a-large-sample
class Solution {
    public double[] sampleStats(int[] count) {
        double min = -1, max = -1, sum = 0;
        double mode = min, modeFreq = 0;
        long n = 0;
        
        for (int i = 0; i < 256; i++) {
            if (count[i] != 0) {
                if (min == -1) {
                    min = i;
                    max = i;
                } else {
                    max = i;
                }
                
                n += count[i];
                sum += 1.0 * i * count[i];
                if (count[i] > modeFreq) {
                    modeFreq = count[i];
                    mode = i;
                }
            }
        }
        
        double mean = sum/n, median = -1, last = -1;
        long cumulative = 0;
        
        for (int i = 0; i < 256; i++) {
            if (count[i] > 0) {
                if (cumulative == n/2) {
                    if (n % 2 == 1) {
                        median = i;
                    } else {
                        median = (last + i)/2;
                    }
                    break;
                } else if (cumulative > n/2) {
                    median = last;
                    break;
                }
                
                cumulative += count[i];
                last = i;
            }
        }
        
        return new double[] {
            min,
            max,
            mean,
            median,
            mode
        };
    }
}