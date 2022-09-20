// https://leetcode.com/problems/maximum-swap
class Solution {
    public int maximumSwap(int num) {
        int[] arr = toArray(num);
        int breakPoint = isMaxAlready(arr);
        if (breakPoint < 0) {
            return num;
        }
        
        int[] max = maxDigit(arr, breakPoint);
        for (int i = 0; i < max[1]; i++) {
            if (arr[i] != max[0] && i != max[1] && arr[i] < max[0]) {
                int t = arr[i];
                arr[i] = max[0];
                arr[max[1]] = t;
                break;
            }
        }
        
        return toNum(arr);
    }
    
    int[] toArray(int num) {
        int len = ((int) Math.log10(num)) + 1;
        int[] res = new int[len];
        
        for (int i = len - 1; i >= 0; i--) {
            res[i] = num % 10;
            num /= 10;
        }
        
        return res;
    }
    
    int isMaxAlready(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                return i - 1;
            }
        }
        
        return -1;
    }
    
    int[] maxDigit(int[] arr, int start) {
        int max = 0, index = -1, i = 0;
        for (int x: arr) {
            if (i < start) {
                i++;
                continue;
            }
            if (x >= max) {
                max = x;
                index = i;
            }
            
            i++;
        }
        
        return new int[] {max, index};
    }
    
    int toNum(int[] arr) {
        int res = 0;
        for (int x: arr) {
            res = res * 10 + x;
        }
        
        return res;
    }
}