// https://leetcode.com/problems/find-consecutive-integers-from-a-data-stream
class DataStream {

    private int value, k, count;

    public DataStream(int value, int k) {
        this.value = value;
        this.k = k;
    }
    
    public boolean consec(int num) {
        if (num != this.value) {
            count = -1;
        }

        return ++count >= this.k;
    }
}

/**
 * Your DataStream object will be instantiated and called as such:
 * DataStream obj = new DataStream(value, k);
 * boolean param_1 = obj.consec(num);
 */