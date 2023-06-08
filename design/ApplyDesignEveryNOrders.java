// https://leetcode.com/problems/apply-discount-every-n-orders
class Cashier {

    Map<Integer, Integer> map = new HashMap<>();
    int n, discount, count = 1;

    public Cashier(int n, int discount, int[] products, int[] prices) {
        this.n = n;
        this.discount = discount;

        for (int i = 0; i < prices.length; i++) {
            map.put(products[i], prices[i]);
        }
    }
    
    public double getBill(int[] product, int[] amount) {
        double sum = 0;
        for (int i = 0; i < amount.length; i++) {
            sum += map.get(product[i]) * amount[i];
        }

        if (count % n == 0) {
            sum = sum * ((100.0 - discount) / 100);
        }

        count += 1;
        return sum;
    }
}

/**
 * Your Cashier object will be instantiated and called as such:
 * Cashier obj = new Cashier(n, discount, products, prices);
 * double param_1 = obj.getBill(product,amount);
 */