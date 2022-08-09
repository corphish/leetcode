// https://leetcode.com/problems/my-calendar-i
class MyCalendar {
    
    // An entry in this map stores the start value of a valid booking as key
    // and end of a valid booking as its value.
    TreeMap<Integer, Integer> map;

    public MyCalendar() {
        map = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        // If map is empty, booking can be made
        if (map.size() == 0) {
            map.put(start, end);
            return true;
        }
        
        // If there is a booking made already at the start time, a new booking
        // on the same start time cannot be made.
        if (map.containsKey(start)) {
            return false;
        }
        
        // Now we have to check for overlap.
        
        // Get the booking that is less than start but the most recent one
        Map.Entry<Integer, Integer> mostRecentLess = map.floorEntry(start);
        
        // If there is no such entry
        if (mostRecentLess == null) {
            // It means the start we are adding is the smallest one we have encountered.
            // We have to check whether it ends before the first entry that we have.
            if (end <= map.firstKey()) {
                map.put(start, end);
                return true;
            } else {
                return false; 
            }
        }
        
        // If the end time of this booking is less than new one's start time,
        // it could be possible made?
        if (mostRecentLess.getValue() <= start) {
            // The start of mostRecentLess cannot be equal to start of new one
            // end of the most recent less is less than start, so I guess its ok.
            // But we will also have to consider the next immediate booking
        } else {
            // Overlaps because the mostRecentLess has started before new one's start
            // but ends after the new one's start.
            return false;
        }
        
        // Get the booking that is greater than start but the most recent one
        Map.Entry<Integer, Integer> mostRecentGreater = map.ceilingEntry(start);
        
        // If the one that we are trying to add has the largest start we have encountered
        // so far, it means we should be able to safely add as this booking starts after the
        // previous one's start and after the previous one's end.
        if (mostRecentGreater == null) {
            map.put(start, end);
            return true;
        }
        
        // If we indeed have a booking made after the new one, we have to check whether it ends before the start of that one
        if (end > mostRecentGreater.getKey()) {
            return false;
        }
        
        // I think at this point we are good to go
        map.put(start, end);        
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */