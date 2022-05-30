// https://leetcode.com/problems/k-th-smallest-prime-fraction
class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        List<Fraction> fractions = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                fractions.add(new Fraction(arr[i], arr[j]));
            }
        }
        
        Collections.sort(fractions);
        
        return fractions.get(k - 1).represent();
    }
    
    class Fraction implements Comparable<Fraction> {
        int n, d;
        
        Fraction(int n, int d) {
            this.n = n;
            this.d = d;
        }
        
        public int compareTo(Fraction other) {
            double c = (n * 1.0)/d;
            double o = (other.n * 1.0)/other.d;
            
            return Double.compare(c, o);
        }
        
        int[] represent() {
            return new int[] {n, d};
        }
    }
}