// https://leetcode.com/problems/find-median-from-data-stream
class MedianFinder {
    // First half elements will be stored here
    // This is in reverse order as we are interested only the last elements of this set.
    PriorityQueue<Integer> firstHalf = new PriorityQueue<>(Collections.reverseOrder());

    // Second half elements will be stored here
    // Idea with 2 sets is that, we would like to have atmost one difference in elements count.
    PriorityQueue<Integer> secondHalf = new PriorityQueue<>();

    // Count
    int count = 0;
    
    // O(log(N))
    public void addNum(int num) {
        // Populate the queues first if they are empty
        if (firstHalf.isEmpty()) {
            firstHalf.add(num);
        } else if (secondHalf.isEmpty()) {
            // We have to make sure that the second element that is added is greater than the previous one
            // If not we will have to make necessary adjustments.
            if (num < firstHalf.peek()) {
                secondHalf.add(firstHalf.poll());
                firstHalf.add(num);
            } else {
                secondHalf.add(num);
            }
        } else {
            // Determine where the element should go
            int firstHalfVal = firstHalf.peek();
            int secondHalfVal = secondHalf.peek();

            // If num <= firstHalfVal, then it goes in firstHalf
            // Similarly, if num >= secondHalfVal, it goes in secondHalf
            // What happens when firstHalfVal < num < secondHalfVal?
            // In that case, we try to add it to the set that has the lower elements
            if (num <= firstHalfVal) {
                if (firstHalf.size() - secondHalf.size() == 1) {
                    // This will violate the property of having atmost 1 difference in element count
                    // between 2 sets, so we add the largest element of firstHalf to second, and then
                    // add the num.
                    secondHalf.add(firstHalf.poll());
                }
                
                firstHalf.add(num);
            } else if (num >= secondHalfVal) {
                if (secondHalf.size() - firstHalf.size() == 1) {
                    // This will violate the property of having atmost 1 difference in element count
                    // between 2 sets, so we add the smallest element of secondHalf to first, and then
                    // add the num.
                    firstHalf.add(secondHalf.poll());
                }
                
                secondHalf.add(num);
            } else {
                // Add to the set with smallest count
                if (firstHalf.size() <= secondHalf.size()) {
                    firstHalf.add(num);
                } else {
                    secondHalf.add(num);
                }
            }
        }

        // Increment count
        count += 1;
    }
    
    // O(1)
    public double findMedian() {
        // For odd, return the head element of the set having more elements
        if (count % 2 == 1) {
            return firstHalf.size() > secondHalf.size() ? firstHalf.peek() : secondHalf.peek();
        } else {
            // Both sets have same no of elements
            // Return average
            return (firstHalf.peek() + secondHalf.peek())/2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */