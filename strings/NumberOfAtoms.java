// https://leetcode.com/problems/number-of-atoms
class Solution {
    public String countOfAtoms(String formula) {
        while (formula.contains("(")) {
            int start = formula.lastIndexOf("(");
            int mid = formula.indexOf(")", start);
            int end;
            String extract = formula.substring(start + 1, mid);
            StringBuilder multiplier = new StringBuilder();

            for (end = mid + 1; end < formula.length() && Character.isDigit(formula.charAt(end)); end++) {
                multiplier.append(formula.charAt(end));
            }

            String extractResolved;
            if (multiplier.isEmpty()) {
                extractResolved = resolve(extract);
            } else {
                extractResolved = resolve(extract, Integer.parseInt(multiplier.toString()));
            }

            formula = formula.substring(0, start) + extractResolved + formula.substring(end);
        }

        return resolve(formula);
    }

    String resolve(String formula) {
        return resolve(formula, 1);
    }

    String resolve(String formula, int multiplier) {
        StringBuilder res = new StringBuilder();
        StringBuilder lastElement = new StringBuilder();
        Map<String, Integer> map = new TreeMap<>();
        int count = 0;

        for (char c: formula.toCharArray()) {
            if (lastElement.isEmpty()) {
                lastElement.append(c);
            } else {
                if (Character.isLowerCase(c)) {
                    lastElement.append(c);
                } else if (Character.isLetter(c)) {
                    count = count == 0 ? 1 : count;
                    map.put(lastElement.toString(), map.getOrDefault(lastElement.toString(), 0) + (count * multiplier));
                    lastElement = new StringBuilder();
                    lastElement.append(c);
                    count = 0;
                } else {
                    // Character should be number
                    int val = c - '0';
                    if (count == 0) {
                        count = val;
                    } else {
                        count = count * 10 + val;
                    }
                }
            }
        }

        if (!lastElement.isEmpty()) {
            count = count == 0 ? 1 : count;
            map.put(lastElement.toString(), map.getOrDefault(lastElement.toString(), 0) + (count * multiplier));
        }

        for (var e: map.entrySet()) {
            res.append(e.getKey());
            if (e.getValue() > 1) {
                res.append(e.getValue());
            }
        }

        return res.toString();
    }
}