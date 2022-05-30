class Solution {
    // Ad hoc
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        //System.out.println(Arrays.toString(ages));
        
        int count = 0;
        
        int hundred = Arrays.binarySearch(ages, 100);
        if (hundred < 0) hundred = -hundred - 1;
        int hundredCount = ages.length - hundred;
        
        //count += combination(hundredCount, 2);
        
        for (int i = ages.length - 1; 
             i >= 0; 
             i--) {
            if (ages[i] < 15) continue;
            
            int minAge = ages[i]/2 + 7;
            int maxAge = ages[i] + 1;
            
            int t = count;
            
            for (int j = i - 1; j >= 0 && ages[j] > minAge; j--, count++);
            for (int j = i + 1; j < ages.length && ages[j] < maxAge; j++, count++);
            
            //System.out.printf("ages[i]=%d, minAge=%d, maxAge=%d, req=%d\n", ages[i], minAge, maxAge, count - t);
        }
        
        return count;
    }
}