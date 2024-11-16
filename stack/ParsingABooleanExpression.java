// https://leetcode.com/problems/parsing-a-boolean-expression
class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> op = new Stack<>();
        Stack<Character> val = new Stack<>();

        for (char c: expression.toCharArray()) {
            if (c == ',') continue;
            if (c == ')') {
                char lastOp = op.pop();
                boolean res = lastOp == '|' ? false : true;
                while (true) {
                    char last = val.pop();
                    if (last == '(') {
                        break;
                    }

                    boolean b = last == 't';
                    if (lastOp == '!') {
                        res = !b;
                    } else if (lastOp == '&') {
                        res = res && b;
                    } else {
                        res = res || b;
                    }
                }

                val.push(res ? 't' : 'f');
            } else {
                if (c == '!' || c == '&' || c == '|') {
                    op.push(c);
                } else {
                    val.push(c);
                }
            }
        }

        return val.pop() == 't';
    }
}