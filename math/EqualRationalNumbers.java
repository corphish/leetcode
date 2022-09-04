// https://leetcode.com/problems/equal-rational-numbers/
class Solution {
    public boolean isRationalEqual(String s, String t) {
        RationalNumber r1 = new RationalNumber(s);
        RationalNumber r2 = new RationalNumber(t);
        
        return r1.equals(r2);
    }
    
    class RationalNumber {
        int base;
        String decimal;
        
        private static final int DECIMAL_LENGTH = 20;
        private static final int EXPANSION_LENGTH = DECIMAL_LENGTH + 5;
        
        RationalNumber(String s) {
            preprocess(s);
            applyAdjustments();
        }
        
        private void preprocess(String s) {
            // Check if there is a dot to split or not
            if (!s.contains(".")) {
                base = Integer.parseInt(s);
                decimal = "0";
                return;
            }
            
            // Split by .
            String[] parts = s.split("\\.");
            
            // First part is our base
            base = Integer.parseInt(parts[0]);
            
            // Second part will be our decimal
            if (parts.length == 2) {
                parseDecimal(parts[1]);
            } else {
                decimal = "0";
            }
        }
        
        private void parseDecimal(String s) {
            // s can be empty
            if (s.isEmpty()) {
                decimal = "0";
                return;
            }
            
            // Extract the repeating and non-repeaing part
            String nonRepeating = "";
            String repeating = "";
            
            // If there is no bracket, entire thing is non-repeating
            int sIndex = s.indexOf("(");
            if (sIndex < 0) {
                nonRepeating = s;
                decimal = nonRepeating;
                return;
            }
            
            nonRepeating = s.substring(0, sIndex);
            repeating = s.substring(sIndex + 1, s.indexOf(")"));
            
            boolean allNines = allNines(repeating);
            boolean allZeroes = allZeroes(repeating);
            
            if (allNines && !nonRepeating.isEmpty()) {
                int leadingZeroes = leadingZeroes(nonRepeating);
                String added = repeat("0", leadingZeroes) + (Integer.parseInt(nonRepeating) + 1);
                if (added.length() != nonRepeating.length()) {
                    base = base + 1;
                    nonRepeating = "0";
                } else {
                    nonRepeating = added;
                }
                repeating = "0";
            } else if (allNines) {
                base = base + 1;
                repeating = "0";
            } else if (allZeroes && !nonRepeating.isEmpty()) {
                repeating = "0";
            } else if (allZeroes) {
                repeating = "0";
            } else {
                repeating = repeat(repeating);
            }
            
            decimal = nonRepeating + repeating;
        }
        
        private int leadingZeroes(String s) {
            int count = 0;
            for (char c: s.toCharArray()) {
                if (c == '0') {
                    count++;
                } else {
                    break;
                }
            }
            
            return count;
        }
        
        private String repeat(String s) {
            StringBuilder sb = new StringBuilder();
            while (sb.length() < EXPANSION_LENGTH) {
                sb.append(s);
            }
            
            return sb.toString();
        }
        
        private String repeat(String s, int count) {
            StringBuilder sb = new StringBuilder();
            while (count-- > 0) {
                sb.append(s);
            }
            
            return sb.toString();
        }
        
        private void applyAdjustments() {
            adjustDecimalLength();
            trimZeroes();
        }
        
        private void adjustDecimalLength() {
            if (decimal.length() > DECIMAL_LENGTH) {
                decimal = decimal.substring(0, DECIMAL_LENGTH);
            }
        }
        
        private void trimZeroes() {
            // Find the last non-zero index
            int index = -1;
            for (int i = decimal.length() - 1; i >= 0; i--) {
                if (decimal.charAt(i) != '0') {
                    index = i;
                    break;
                }
            }
            
            decimal = decimal.substring(0, index + 1);
        }
        
        private boolean allZeroes(String s) {
            // If all are zeroes, reduce it to single digit
            boolean allZeroes = true;
            for (char c: s.toCharArray()) {
                if (c != '0') {
                    allZeroes = false;
                    break;
                }
            }
            
            return allZeroes;
        }
        
        private boolean allNines(String s) {
            // If all are nines, increment to next number
            boolean allNines = true;
            for (char c: s.toCharArray()) {
                if (c != '9') {
                    allNines = false;
                    break;
                }
            }
            
            return allNines;
        }
        
        public boolean equals(Object other) {
            if (!(other instanceof RationalNumber)) {
                return false;
            }
            
            RationalNumber o = (RationalNumber) other;
            
            return this.base == o.base && this.decimal.equals(o.decimal);
        }
        
        public String toString() {
            return base + "." + decimal;
        }
    }
}