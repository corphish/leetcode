// https://leetcode.com/problems/seat-reservation-manager
// Use a TreeSet to hold all the unreserved seats.
// While reserving, return the smallest one.
// While unreserving add back the seat that is being unreserved.
class SeatManager {
    
    TreeSet<Integer> set = new TreeSet<>();

    public SeatManager(int n) {
        for (int i = 1; i <= n; i++) set.add(i);
    }
    
    public int reserve() {
        return set.pollFirst();
    }
    
    public void unreserve(int seatNumber) {
        set.add(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */