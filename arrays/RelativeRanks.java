// https://leetcode.com/problems/relative-ranks
class Solution {
    // Store the score and index in a data class and store them in an array.
    // Sort the new data array using score in descending order.
    // Now in the resulting array, put the appropriate medal information in the index maintained in the data element.
    public String[] findRelativeRanks(int[] score) {
        Data[] arr = new Data[score.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Data(score[i], i);
        }
        
        Arrays.sort(arr);
        String[] res = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[arr[i].index] = i == 0 ? "Gold Medal" : i == 1 ? "Silver Medal" : i == 2 ? "Bronze Medal" : (i + 1) + "";
        }
        
        return res;
    }
    
    class Data implements Comparable<Data> {
        int score, index;
        
        Data(int score, int index) {
            this.score = score;
            this.index = index;
        }
        
        public int compareTo(Data other) {
            return other.score - this.score;
        }
    }
}