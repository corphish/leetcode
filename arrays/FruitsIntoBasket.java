// https://leetcode.com/problems/fruit-into-baskets/
class Solution {
    public int totalFruit(int[] fruits) {
        int max = 0, i = 0, j;
        int[] freq = new int[fruits.length];
        freq[fruits[0]]++;
        
        if (fruits.length == 1) return 1;
        
        // Find the next element in array whose value is not
        // equal to fruits[0]
        for (j = 1; j < fruits.length && fruits[j] == fruits[0]; j++) {
            freq[fruits[j]]++;
        }
        
        if (j == fruits.length) {
            return fruits.length;
        }
        
        freq[fruits[j]]++;
        max = j - i + 1;
        j = j + 1;
        
        while (j < fruits.length) {
            if (freq[fruits[j]] > 0) {
                freq[fruits[j]]++;
                max = Math.max(max, j - i + 1);
                j = j + 1;
            } else {
                while (i < fruits.length) {
                    freq[fruits[i]]--;
                    if (freq[fruits[i]] == 0) {
                        i = i + 1;
                        break;
                    } else {
                        i++;
                    }
                }
                
                freq[fruits[j]]++;
                max = Math.max(max, j - i + 1);
                j = j + 1;
            }
        }
        
        return max;
    }
}