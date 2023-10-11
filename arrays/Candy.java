// https://leetcode.com/problems/candy
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length, sum = 0;
        Data[] dataset = new Data[n];
        int[] candies = new int[n];
        
        for (int i = 0; i < n; i++) {
            dataset[i] = new Data(ratings[i], i);
        }
        
        Arrays.sort(dataset);
        
        for (int i = 0; i < n; i++) {
            int minIndex = dataset[i].index;
            int pLeft = safeAccess(ratings, minIndex - 1);
            int pRight = safeAccess(ratings, minIndex + 1);
            int p = ratings[minIndex];
            
            if (p <= pLeft && p <= pRight) {
                candies[minIndex] = 1;
            } else if(p > pRight && p > pLeft) {
                candies[minIndex] = Math.max(candies[minIndex + 1], candies[minIndex - 1]) + 1;
            } else if (p > pRight) {
                candies[minIndex] = candies[minIndex + 1] + 1;
            } else if (p > pLeft) {
                candies[minIndex] = candies[minIndex - 1] + 1;
            }
            
            sum += candies[minIndex];
        }
        
        return sum;
    }
    
    int safeAccess(int[] arr, int i) {
        return i < 0 || i >= arr.length ? Integer.MAX_VALUE : arr[i];
    }
    
    class Data implements Comparable<Data> {
        int val, index;
        
        Data(int val, int index) {
            this.val = val;
            this.index = index;
        }
        
        public int compareTo(Data other) {
            return this.val == other.val ? this.index - other.index : this.val - other.val;
        }
    }
}