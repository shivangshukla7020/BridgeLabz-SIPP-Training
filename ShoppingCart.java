import java.util.*;

public class ShoppingCart {
    Map<String, Double> prices = new HashMap<>();
    LinkedHashMap<String, Integer> cart = new LinkedHashMap<>();

    public void addProduct(String product, double price, int qty) {
        prices.put(product, price);
        cart.put(product, cart.getOrDefault(product, 0) + qty);
    }

    public TreeMap<Double, String> sortedByPrice() {
        TreeMap<Double, String> sorted = new TreeMap<>();
        for (String p : cart.keySet()) sorted.put(prices.get(p), p);
        return sorted;
    }

    public static void main(String[] args) {
        ShoppingCart sc = new ShoppingCart();
        sc.addProduct("Apple", 50, 2);
        sc.addProduct("Banana", 20, 5);
        sc.addProduct("Orange", 30, 3);
        System.out.println("Cart: " + sc.cart);
        System.out.println("Sorted by price: " + sc.sortedByPrice());
    }
}
