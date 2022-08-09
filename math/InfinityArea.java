public class InfinityArea {
    public static void main(String[] args) {
        int r = 5, a = 2, b = 5;
        double areaSum = 0;
        int n = getMaxN(r, a);

        for (int i = 0; i < n; i++) {
            int t = nthTerm(i, r, a, b);
            if (t == 0) break;
            areaSum += Math.PI * t * t;
        }

        System.out.println(areaSum);
    }

    static double log2(int n) {
        return Math.log(n)/Math.log(2);
    }

    static int getMaxN(int r, int a) {
        return 2 * (int) (log2(r * a));
    }

    static int nthTerm(int n, int r, int a, int b) {
        int aVal = (int) Math.pow(a, n % 2 == 1 ? n/2 + 1 : n/2);
        int bVal = (int) Math.pow(b, n/2);

        //System.out.println("aVal = " + aVal + ", bVal = " + bVal);

        return (r * aVal)/bVal;
    }
}