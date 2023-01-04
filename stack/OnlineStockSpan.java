// https://leetcode.com/problems/online-stock-span
class StockSpanner() {

    val stack = ArrayDeque<Stock>()

    fun next(price: Int): Int {
        if (stack.isEmpty() || stack.peekLast().value > price) {
            stack.addLast(Stock(price))
            return 1
        }

        var count = 0
        while (!stack.isEmpty() && stack.peekLast().value <= price) {
            val removed = stack.removeLast()
            count = count + 1 + removed.score
        }

        stack.addLast(Stock(price, count))
        return count + 1
    }

    data class Stock(val value: Int, val score: Int = 0)
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * var obj = StockSpanner()
 * var param_1 = obj.next(price)
 */