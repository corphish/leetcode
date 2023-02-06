public class RangeTest {
    public static void main(String[] args) {
        RangeModule rm = new RangeModule();
        int[][] ranges = {{1,5},{6,8},{0,9}};
        //int[][] ranges = {{1,2},{3,5},{6,7},{8,10},{12,16},{4,8}};

        for (int[] range: ranges) {
            Range r = new Range(range);
            boolean res = rm.add(r);
            if (!res) {
                System.out.println("Failed to add " + r);
            } else {
                rm.show();
            }
        }

        rm.performSanity();
        System.out.println("After sanity");
        rm.show();
    }
}
