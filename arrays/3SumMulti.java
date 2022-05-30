// https://leetcode.com/problems/3sum-with-multiplicity
class Solution {
    public int threeSumMulti(int[] arr, int target) {
        Arrays.sort(arr);
        long count = 0;
        int[] lastIndexes = new int[arr[arr.length - 1] + 1];
        int[] firstIndexes = new int[arr[arr.length - 1] + 1];
        
        Arrays.fill(firstIndexes, -1);
        Arrays.fill(lastIndexes, -1);
        
        for (int i = 0; i < arr.length; i++) {
            if (firstIndexes[arr[i]] == -1) {
                firstIndexes[arr[i]] = i;
            }
            
            lastIndexes[arr[i]] = i;
        }
        
        //System.out.println(Arrays.toString(lastIndexes));
        //System.out.println(Arrays.toString(firstIndexes));
        
        for (int i = 0; i < arr.length - 2; i++) {
            //freq[arr[i]]--;
            //int t = freq[arr[i + 1]];
            for (int j = i + 1; j < arr.length - 1; j++) {
                int x = target - arr[i] - arr[j];
                //int ix = Arrays.binarySearch(arr, j + 1, arr.length, x);
                if (x <= arr[arr.length - 1] && x >= 0 && lastIndexes[x] > j) {
                    // Adjust the start and end range
                    // [0,2,2,2,3]
                    // l = 0, r = 4
                    int l = Math.max(j + 1, firstIndexes[x]), r = Math.max(j + 1, lastIndexes[x]);
                    
                    //System.out.printf("arr[%d]=%d, arr[%d]=%d, x=%d, l=%d, r=%d\n", i, arr[i], j, arr[j], x, l, r);
                    count += (r - l + 1);
                }
                    
            }
            
            //freq[arr[i + 1]] = t - 1;
        }
        
        return (int) (count % 1000000007);
    }
}