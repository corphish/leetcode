class Solution {
    // Generate palindromes.
    // Square the generated the palindrome, check if it is a palindrome, if so, increment counter.
    public int superpalindromesInRange(String left, String right) {
        long l = Long.parseLong(left);
        long r = Long.parseLong(right);
        
        int count = 0;
        
        PalindromeGenerator pg = new PalindromeGenerator();
        
        boolean isOutOfBounds = false;
        while (!isOutOfBounds) {
            long pal = pg.next();
            long sq = pal * pal;
            
            if (sq > r) {
                isOutOfBounds = true;
            }
            
            if (sq >= l && sq <= r) {
                if (isPalindrome(sq)) {
                    count++;
                }
            }
        }
        
        return count;
    }
    
    boolean isPalindrome(long n) {
        long rev = 0;
        for (long k = n; k > 0; k /= 10) {
            rev = rev * 10 + (k % 10);
        }
        
        return rev == n;
    }
    
    
    class PalindromeGenerator {
        // Representation of current palindrome stored as an array of digits
        long[] rep;
        
        // Current size
        int size;
        
        // Set of smallest palindromes of any given length.
        TreeSet<Long> firsts;
        
        PalindromeGenerator() {
            rep = new long[1];
            size = 1;
            determineSmallestPalindromes();
        }
        
        // Fills the firsts
        private void determineSmallestPalindromes() {    
            firsts = new TreeSet<>();
            
            long k = 10;
            while (k <= 10000000000000L) {
                firsts.add(k + 1);
                k *= 10;
            }
        }
        
        private long[] toArray(long n) {
            int size = (int) Math.log10(n);
            long[] arr = new long[size + 1];
            int i = size;
            while (n > 0) {
                arr[i--] = n % 10;
                n /= 10;
            }
            
            return arr;
        }
        
        long toLong(long[] arr) {
            long n = 0;
            for (long x: arr) {
                n = n * 10 + x;
            }
            
            return n;
        }
        
        long next() {
            boolean res = buildNextPalindrome(0, size - 1);
            if (!res) {
                rep = toArray(firsts.pollFirst());
                size = rep.length;
            }
            
            return toLong(rep);
        }
        
        // Builds the next palindrome inside rep
        // l and r are inclusive
        // Logic to generate palindrome:
        // Maintain an array which represents a digit of a palindrome number (rep)
        // We would like increase the middle digit (in case of odd length), or the middle digits (in case of even length)
        // If it is possible to increase this values by 1, increase them, else (if the value is/are 9), we set it to 0 and we have to
        // some how indicate that their neighboring digits have to be increased. Perform this recursively.
        // The way we indicate whether a required digit was successfully increase or not is by returning true. We return false otherwise.
        // This function will return false if it is trying to generate the next palindrome number of palindrome which is already the largest
        // palindrome of its length.
        // In such cases, we pre compute the smallest palindrome of each length (10^i + 1 for i >= 1) and start of with that.
        private boolean buildNextPalindrome(int l, int r) {
            if (l > r) {
                return false;
            }
            
            if (l == r) {
                if (rep[l] == 9) {
                    rep[l] = 0;
                    return false;
                } else {
                    rep[l]++;
                    return true;
                }
            } else if (l == r - 1) {
                // Both rep[l] and rep[r] should be equal
                if (rep[l] == 9) {
                    rep[l] = 0;
                    rep[r] = 0;
                    return false;
                } else {
                    rep[l]++;
                    rep[r]++;
                    return true;
                }
            } else {
                // Both rep[l] and rep[r] should be equal
                boolean res = buildNextPalindrome(l + 1, r - 1);
                if (!res) {
                    if (rep[l] == 9) {
                        rep[l] = 0;
                        rep[r] = 0;
                        return false;
                    } else {
                        rep[l]++;
                        rep[r]++;
                        return true;
                    }
                } else {
                    return true;
                }
            }
        }
    }
}