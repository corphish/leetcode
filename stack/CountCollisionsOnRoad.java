// https://leetcode.com/problems/count-collisions-on-a-road
class Solution {
    public int countCollisions(String directions) {
        int r = 0, l = 0, s = 0, count = 0;
        int ri = -1, si = -1, li = -1, i = 0;
        
        for (char c: directions.toCharArray()) {
            // If the car is moving towards right, we count it
            if (c == 'R') {
                r++;
                
                // Any previous stationary cars or cars moving left are safe
                s = 0;
                l = 0;
                ri = i;
            } else if (c == 'S') {
                // All the cars that were previously travelling right will collide with this car
                count += r;
                r = 0;
                s++;
                si = i;
            } else {
                // Now we check for any collision
                
                // If it will collide with S first
                if (si > ri) {
                    count++;    
                } else if (ri >= 0) {
                    // Collision can only take place if there was indeed any car travelling R before
                    count += r > 0 ? 2 : 0;
                    
                    // This position now becomes stationary
                    // But any cars that were behind the colliding with R which were travelling in R will also collide
                    count += r > 0 ? r - 1 : 0;
                    r = 0;
                    si = i;
                }
                
                li = i;
            }
            
            i++;
        }
        
        return count;
    }
}