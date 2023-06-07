// https://leetcode.com/problems/fraction-addition-and-subtraction
class Solution {
    public String fractionAddition(String expression) {
        expression = expression.replace("-", "+-");
        String[] parts = expression.split("\\+");

        int num = 0, den = 1;
        for (String part: parts) {
            if (part.isEmpty()) {
                continue;
            }

            int[] fract = parse(part);
            normalise(fract);

            num = fract[1] * num + den * fract[0];
            den = den * fract[1];
        }

        return express(reduce(num, den));
    }

    int[] parse(String part) {
        String[] parts = part.split("/");
        return new int[] {
            Integer.parseInt(parts[0]),
            Integer.parseInt(parts[1]),
        };
    }

    int[] reduce(int num, int den) {
        int d = gcd(num, den);
        return new int[] {
            num/d,
            den/d
        };
    }

    void normalise(int[] fraction) {
        if (fraction[0] > 0 && fraction[1] < 0) {
            fraction[0] = -fraction[0];
            fraction[1] = -fraction[1];
        }
    }

    String express(int[] fraction) {
        normalise(fraction);
        return fraction[0] + "/" + fraction[1];
    }

    int gcd(int x, int y) {
        return x % y == 0 ? y : gcd(y, x % y);
    }
}