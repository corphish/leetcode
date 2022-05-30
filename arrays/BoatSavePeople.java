class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        
        /*int[] res = {
            method1(people, limit),
            method2(people, limit),
            method3(people, limit),
        };*/
       
        //System.out.println("New");
        //System.out.println("Results = " + Arrays.toString(res));
        
        //Arrays.sort(res);
        
        return Math.min(
            method1(people, limit),
            Math.min(
                method2(people, limit),
                method3(people, limit)
            )
        );
    }
    
    // Method 1
    // Try to put the lightest and the heaviest one at one go
    int method1(int[] people, int limit) {
        int count = 0, weight = 0, pCount = 0;
        int l = 0, r = people.length - 1;
        
        for (; l <= r; l++) {
            if (weight + people[l] + people[r] <= limit) {
                count++;
                r--;
            } else {
                if (weight + people[l] <= limit && pCount == 0) {
                    weight += people[l];
                    pCount++;
                } else {
                    count++;
                    weight = people[l];
                    pCount = 0;
                }
            }
        }
        
        return count + 1;
    }
    
    // Method 2
    // Try to put as many light ones as possible
    int method2(int[] people, int limit) {
        int count = 0, weight = 0, pCount = 0;
        for (int i = 0; i < people.length; i++) {
            if (weight + people[i] <= limit && pCount == 0) {
                weight += people[i];
                pCount++;
            } else {
                count++;
                weight = people[i];
                pCount = 0;
            }
        }
        
        return count + 1;
    }
    
    // Method 3
    // Try to put a heavy person and then put 1 light one
    int method3(int[] people, int limit) {
        int count = 0, weight = 0;
        int l = 0, r = people.length - 1;
        
        for (; l <= r; r--) {
            weight = people[r];
            if (weight + people[l] <= limit) {
                l++;
            }
            
            count++;
        }
        
        return count;
    }
}